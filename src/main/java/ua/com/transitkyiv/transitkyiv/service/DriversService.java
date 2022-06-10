package ua.com.transitkyiv.transitkyiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Drivers;
import ua.com.transitkyiv.transitkyiv.repository.DriversRepository;

import java.util.List;

@Service
public class DriversService {

    private final DriversRepository driversRepository;

    @Autowired
    public DriversService(DriversRepository driversRepository){
        this.driversRepository = driversRepository;
    }

    public List<Drivers> getAllDrivers(){
        return driversRepository.findAll();
    }

    public void save(Drivers driver) {
        driversRepository.save(driver);
    }

    //delete driver by firstName and lastName
    public void deleteDriverByFirstNameAndLastName(String firstName, String lastName) {
        driversRepository.deleteDriverByFirstNameAndLastName(firstName, lastName);
    }
}
