package ua.com.transitkyiv.transitkyiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Transports;
import ua.com.transitkyiv.transitkyiv.repository.TransportsRepository;

import java.util.List;

@Service
public class TransportsService {

    // репозиторий транспорта
    private final TransportsRepository transportsRepository;

    // связываем с сервисом
    @Autowired
    public TransportsService(TransportsRepository transportsRepository){
        this.transportsRepository = transportsRepository;
    }

    // метод получения списка всего транспорта
    public List<Transports> getAllTransports(){
        return transportsRepository.findAll();
    }

}
