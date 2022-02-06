package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Routes;
import ua.com.transitkyiv.transitkyiv.entity.Transports;

import java.util.List;

public interface RoutesRepository extends JpaRepository<Routes, Long>, ExtendedRoutesRepository {
}
