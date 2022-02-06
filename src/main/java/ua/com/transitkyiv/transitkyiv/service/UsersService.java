package ua.com.transitkyiv.transitkyiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.UserRoles;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.repository.UserRolesRepository;
import ua.com.transitkyiv.transitkyiv.repository.UsersRepository;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, UserRolesRepository userRolesRepository){
        this.usersRepository = usersRepository;
        this.userRolesRepository = userRolesRepository;
    }

    public boolean isUser(String username, String password){
        Users users = usersRepository.findByUserNameAndPassword(username, password);
        return users != null;
    }

    public boolean isUserByUserName(String username){
        Users users = usersRepository.findByUserName(username);
        return users != null;
    }

    public Users getUser(String username){
        return usersRepository.findByUserName(username);
    }

    public void saveNewUser(Users users){
        usersRepository.save(users);
    }

    public void saveNewUserRole(Users users){
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("user");
        userRoles.setTkuser(users);

        userRolesRepository.save(userRoles);
    }

    public UserRoles getUserRolesByUser(Users users){
        return userRolesRepository.findUserRolesByTkuserAndRoleEquals(users, "admin");
    }
}
