package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.RouteStops;

public interface RouteStopsRepository extends JpaRepository<RouteStops, Long> {
}
