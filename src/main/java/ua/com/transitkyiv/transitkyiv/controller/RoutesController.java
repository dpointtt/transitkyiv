package ua.com.transitkyiv.transitkyiv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.service.RoutesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class RoutesController {

    // сервис маршрутов
    private final RoutesService routesService;

    // связываем с контроллером
    @Autowired
    public RoutesController(RoutesService routesService){
        this.routesService = routesService;
    }

    // прослушивание страницы "Список маршрутов"
    @RequestMapping(value = { "/routeslist" }, method = RequestMethod.GET)
    public String viewRoutesList(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        // проверка пользователя
        if(Objects.isNull(user)){
            return "redirect:/login";
        }else{
            // передаем список маршрутов в freemarker
            model.addAttribute("routes", routesService.getAllRoutes());
            return "routeslist";
        }
    }

    // прослушивание страницы определенного маршрута
    // обезательный параметр rid нужен для определенныя маршрута который просматривает пользователь
    @RequestMapping(value = { "/route" }, method = RequestMethod.GET)
    public String viewRoute(@RequestParam(value = "rid", required = false)Long r_id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        // проверка пользователя
        if(Objects.isNull(user)){
            return "redirect:/login";
            // проверка маршрута по id
        }else if (Objects.nonNull(r_id) && routesService.isRoutesIdAvailable(r_id)) {
            model.addAttribute("routeV", routesService.getRouteById(r_id));
            return "routeinfo";
        } else {
            // возвращаем страницу с ошибкой в случае неудачной проверки по id
            model.addAttribute("errortype", "notfound");
            return "errorpage";
        }
    }

    // прослушивание страницы с поиском маршрутов
    @RequestMapping(value = { "/find-route" }, method = RequestMethod.GET)
    public String viewFindRoute(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        // проверка пользователя
        if(Objects.isNull(user)){
            return "redirect:/login";
        }else{
            // передаем список маршрутов(так как мы их еще не искали, то передаем все)
            model.addAttribute("froutes", routesService.getAllRoutes());
            return "findroute";
        }
    }

    // обработка введенных данных на странице с поиском маршрутов
    // параметр transport отвечает за вид транспорта по которому ведется поиск
    // если транспорт не указан, то поиск ведется по любому транспорту
    // параметры from и to Address отвечают за то, по каким остановкам ведется поиск
    @RequestMapping(value = { "/find-route" }, method = RequestMethod.POST)
    public String getFindRoute(@RequestParam String transport, @RequestParam String fromAddress, @RequestParam String toAddress, Model model){
        if(transport.isEmpty()){
            model.addAttribute("froutes", routesService.getRoutesFromTo(fromAddress, toAddress));
        }else{
            model.addAttribute("froutes", routesService.getRoutesFromToByTransport(fromAddress, toAddress, transport));
        }
        return "findroute";
    }

}
