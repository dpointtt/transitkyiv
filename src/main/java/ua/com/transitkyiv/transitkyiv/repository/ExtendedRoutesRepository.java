package ua.com.transitkyiv.transitkyiv.repository;

import ua.com.transitkyiv.transitkyiv.entity.Routes;

import java.util.List;

public interface ExtendedRoutesRepository {
    List<Routes> findFromTo(String fromAddress, String toAddress);
    List<Routes> findFromToTran(String fromAddress, String toAddress, String transport);
    List<Routes> findRoutesTransports(String transport);
}
