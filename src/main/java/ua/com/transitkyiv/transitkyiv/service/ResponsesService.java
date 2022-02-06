package ua.com.transitkyiv.transitkyiv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.transitkyiv.transitkyiv.entity.Responses;
import ua.com.transitkyiv.transitkyiv.repository.ResponsesRepository;

@Service
public class ResponsesService {

    // репозиторий отзывов
    private final ResponsesRepository responsesRepository;

    // связываем с сервисом
    @Autowired
    public ResponsesService(ResponsesRepository responsesRepository){
        this.responsesRepository = responsesRepository;
    }

    // метод сохранения отзыва пользователя
    public void saveNewResponse(String responsetext, String username){
        Responses responses = new Responses();
        responses.setResponseText(responsetext);
        responses.setTkUsername(username);
        responsesRepository.save(responses);
    }

}
