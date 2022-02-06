package ua.com.transitkyiv.transitkyiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Transports;
import ua.com.transitkyiv.transitkyiv.repository.TransportsRepository;

import java.util.List;

@Service
public class TransportsService {

    private final TransportsRepository transportsRepository;

    @Autowired
    public TransportsService(TransportsRepository transportsRepository){
        this.transportsRepository = transportsRepository;
    }

    public List<Transports> getAllTransports(){
        return transportsRepository.findAll();
    }

}
