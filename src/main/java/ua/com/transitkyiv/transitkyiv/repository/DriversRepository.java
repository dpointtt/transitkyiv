package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Drivers;

public interface DriversRepository extends JpaRepository<Drivers, Long> {
    void deleteDriverByFirstNameAndLastName(String firstName, String lastName);
}
