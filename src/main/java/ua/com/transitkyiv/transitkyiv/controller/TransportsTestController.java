package ua.com.transitkyiv.transitkyiv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.transitkyiv.transitkyiv.service.TransportsService;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class TransportsTestController {

    private final TransportsService transportsService;

    @Autowired
    public TransportsTestController(TransportsService transportsService){
        this.transportsService = transportsService;
    }

    @RequestMapping(value = { "/transportlist" }, method = RequestMethod.GET)
    public String transportPage(Model model){
        model.addAttribute("transports", transportsService.getAllTransports());
        return "transportlist";
    }

}
