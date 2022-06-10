package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Stops;

public interface StopsRepository extends JpaRepository<Stops, Long> {

    void deleteStopByStopAddress(String stopAddress);

    Stops findByStopAddress(String stopAddress);
}
