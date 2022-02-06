package ua.com.transitkyiv.transitkyiv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.service.ResponsesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class ResponsesController {

    // сервис отзывов
    private final ResponsesService responsesService;

    // связываем с контроллером
    @Autowired
    public ResponsesController(ResponsesService responsesService){
        this.responsesService = responsesService;
    }

    // прослушивание страницы отзывов
    @RequestMapping(value = {"/send-response"}, method = RequestMethod.GET)
    public String viewSendResponsePage(HttpServletRequest request){
        HttpSession session = request.getSession();
        // проверка вошел ли пользователь в систему
        if(Objects.nonNull(session.getAttribute("user"))){
            return "sendresponse";
        }else{
            return "redirect:/login";
        }
    }

    // обработка отправленного отзыва и вывод страницы об успешной отправке
    @RequestMapping(value = {"/send-response"}, method = RequestMethod.POST)
    public String sendResponseTK(@RequestParam String responseText, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        responsesService.saveNewResponse(responseText, users.getUserName());
        return "sendresponsesuccess";
    }

}
