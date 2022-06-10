package ua.com.transitkyiv.transitkyiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.UserRoles;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.repository.UserRolesRepository;
import ua.com.transitkyiv.transitkyiv.repository.UsersRepository;

import java.util.List;

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
        Users users = usersRepository.findByUserNameAndTkpassword(username, password);
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
    public void saveNewUserRole(Users users, String role){
        UserRoles userRoles = new UserRoles();
        userRoles.setTkRole(role);
        userRoles.setTkuser(users);

        userRolesRepository.save(userRoles);
    }

    // метод который возвращает роль, если пользователь админ(проверка на админ права)
    public UserRoles checkAdmin(Users users){
        return userRolesRepository.findUserRolesByTkuserAndTkRoleEquals(users, "admin");
    }

    // get all users
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    //delete user by userName
    public void deleteUserByUserName(String userName){
        usersRepository.deleteByUserName(userName);
    }

}
