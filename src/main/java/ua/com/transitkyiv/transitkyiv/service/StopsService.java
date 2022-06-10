package ua.com.transitkyiv.transitkyiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Stops;
import ua.com.transitkyiv.transitkyiv.repository.StopsRepository;

import java.util.List;
import java.util.Objects;

@Service
public class StopsService {

    private final StopsRepository stopsRepository;

    @Autowired
    public StopsService(StopsRepository stopsRepository){
        this.stopsRepository = stopsRepository;
    }

    //save new stop
    public void save(Stops stop) {
        stopsRepository.save(stop);
    }

    //check if stop exists
    public boolean checkIfStopExists(String stopAddress){
        return Objects.nonNull(stopsRepository.findByStopAddress(stopAddress));
    }

    //delete stop
    public void deleteStopByStopAddress(String stopAddress) {
        stopsRepository.deleteStopByStopAddress(stopAddress);
    }

    //get all stops
    public List<Stops> getAllStops(){
        return stopsRepository.findAll();
    }

}
