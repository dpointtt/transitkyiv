package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.transitkyiv.transitkyiv.entity.Transports;

public interface TransportsRepository extends JpaRepository<Transports, Long> {
    Transports findTransportsByTransportEquals(String Transport);
}
