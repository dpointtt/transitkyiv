package ua.com.transitkyiv.transitkyiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Routes;
import ua.com.transitkyiv.transitkyiv.repository.RoutesRepository;

import java.util.List;

@Service
public class RoutesService {

    private final RoutesRepository routesRepository;

    @Autowired
    public RoutesService(RoutesRepository routesRepository){
        this.routesRepository = routesRepository;
    }

    public List<Routes> getAllRoutes(){
        return routesRepository.findAll();
    }

    public Routes getRouteById(Long id){
        return routesRepository.findById(id).orElse(new Routes());
    }

    public List<Routes> getRoutesFromToByTransport(String fromAddress, String toAddress, String transport){
        return routesRepository.findFromToTran(fromAddress, toAddress, transport);
    }

    public List<Routes> getRoutesFromTo(String fromAddress, String toAddress){
        return routesRepository.findFromTo(fromAddress, toAddress);
    }

    public boolean isRoutesIdAvailable(Long r_id){
        List<Routes> routesList = routesRepository.findAll();
        return r_id <= routesList.size();
    }
}
