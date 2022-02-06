package ua.com.transitkyiv.transitkyiv.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@EnableAutoConfiguration
@ComponentScan()
public class MainController {

    @GetMapping("/")
    public String viewHome(){
        return "index";
    }

}
