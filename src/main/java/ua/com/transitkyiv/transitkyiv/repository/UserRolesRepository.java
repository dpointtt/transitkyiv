package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.UserRoles;
import ua.com.transitkyiv.transitkyiv.entity.Users;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
    // для проверки есть ли у пользователя определенная роль
    UserRoles findUserRolesByTkuserAndRoleEquals(Users TKuser, String Role);
}
