package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserNameAndPassword(String UserName, String Password);
    Users findByUserName(String UserName);
}
