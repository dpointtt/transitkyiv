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

    private final RoutesService routesService;

    @Autowired
    public RoutesController(RoutesService routesService){
        this.routesService = routesService;
    }

    @RequestMapping(value = { "/routeslist" }, method = RequestMethod.GET)
    public String viewRoutesList(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if(Objects.isNull(user)){
            return "redirect:/login";
        }else{
            model.addAttribute("routes", routesService.getAllRoutes());
            return "routeslist";
        }
    }

    @RequestMapping(value = { "/route" }, method = RequestMethod.GET)
    public String viewRoute(@RequestParam(value = "rid", required = false)Long r_id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if(Objects.isNull(user)){
            return "redirect:/login";
        }else if (Objects.nonNull(r_id) && routesService.isRoutesIdAvailable(r_id)) {
            model.addAttribute("routeV", routesService.getRouteById(r_id));
            return "routeinfo";
        } else {
            model.addAttribute("errortype", "notfound");
            return "errorpage";
        }
    }

    @RequestMapping(value = { "/find-route" }, method = RequestMethod.GET)
    public String viewFindRoute(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if(Objects.isNull(user)){
            return "redirect:/login";
        }else{
            model.addAttribute("froutes", routesService.getAllRoutes());
            return "findroute";
        }
    }

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
