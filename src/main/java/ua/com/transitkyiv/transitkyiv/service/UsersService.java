package ua.com.transitkyiv.transitkyiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.UserRoles;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.repository.UserRolesRepository;
import ua.com.transitkyiv.transitkyiv.repository.UsersRepository;

@Service
public class UsersService {

    // репозитории пользователей и ролей пользователей
    private final UsersRepository usersRepository;
    private final UserRolesRepository userRolesRepository;

    // связываем с сервисом
    @Autowired
    public UsersService(UsersRepository usersRepository, UserRolesRepository userRolesRepository){
        this.usersRepository = usersRepository;
        this.userRolesRepository = userRolesRepository;
    }

    // метод по которому узнаем есть ли такой пользователь в базе даних
    public boolean isUser(String username, String password){
        Users users = usersRepository.findByUserNameAndPassword(username, password);
        return users != null;
    }

    // метод по которому узнаем есть ли пользователь с таким логином в базе даних
    public boolean isUserByUserName(String username){
        Users users = usersRepository.findByUserName(username);
        return users != null;
    }

    // метод который возвращает пользователя по логину
    public Users getUser(String username){
        return usersRepository.findByUserName(username);
    }

    // метод который сохраняет нового пользователя
    public void saveNewUser(Users users){
        usersRepository.save(users);
    }

    // метод который добавляет для нового пользователя роль
    public void saveNewUserRole(Users users){
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("user");
        userRoles.setTkuser(users);

        userRolesRepository.save(userRoles);
    }

    // метод который возвращает роль, если пользователь админ(проверка на админ права)
    public UserRoles getUserRolesByUser(Users users){
        return userRolesRepository.findUserRolesByTkuserAndRoleEquals(users, "admin");
    }
}
