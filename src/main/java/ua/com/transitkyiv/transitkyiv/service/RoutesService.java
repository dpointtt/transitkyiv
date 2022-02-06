package ua.com.transitkyiv.transitkyiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Routes;
import ua.com.transitkyiv.transitkyiv.repository.RoutesRepository;

import java.util.List;

@Service
public class RoutesService {

    // репозиторий маршрутов
    private final RoutesRepository routesRepository;

    // связываем с сервисом
    @Autowired
    public RoutesService(RoutesRepository routesRepository){
        this.routesRepository = routesRepository;
    }

    // метод получения списка всех маршрутов
    public List<Routes> getAllRoutes(){
        return routesRepository.findAll();
    }

    // метод получения маршрута по id
    public Routes getRouteById(Long id){
        return routesRepository.findById(id).orElse(new Routes());
    }

    // метод получения списка маршрутов которые двигаются от одной остановки до другой
    // и на конкретном транспорте
    public List<Routes> getRoutesFromToByTransport(String fromAddress, String toAddress, String transport){
        return routesRepository.findFromToTran(fromAddress, toAddress, transport);
    }

    // метод получения списка маршрутов которые двигаются от одной остановки до другой
    public List<Routes> getRoutesFromTo(String fromAddress, String toAddress){
        return routesRepository.findFromTo(fromAddress, toAddress);
    }

    // метод по которому определяем доступен ли маршрут с таким id
    public boolean isRoutesIdAvailable(Long r_id){
        List<Routes> routesList = routesRepository.findAll();
        return r_id <= routesList.size();
    }
}
