package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // посик пользователя по логину и паролю
    Users findByUserNameAndTkpassword(String UserName, String Tkpassword);
    // поиск пользователя по имени
    Users findByUserName(String UserName);

    void deleteByUserName(String userName);
}
