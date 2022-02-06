package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Responses;

public interface ResponsesRepository extends JpaRepository<Responses, Long> {
}
