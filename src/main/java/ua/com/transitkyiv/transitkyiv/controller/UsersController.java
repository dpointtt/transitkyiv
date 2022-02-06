package ua.com.transitkyiv.transitkyiv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }



    // LOGIN

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if(Objects.nonNull(users)){
            return "redirect:/";
        }else {
            return "login";
        }
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String getUserFromDB(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        if(usersService.isUser(username, password)){
            session.setAttribute("user", usersService.getUser(username));
            model.addAttribute("user_", usersService.getUser(username));
            return "loginsuccess";
        }else{
            return "redirect:/login";
        }

    }



    // REGISTRATION

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String getRegPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if(Objects.nonNull(users)){
            return "redirect:/";
        }else {
            model.addAttribute("tkusers", new Users());
            return "registration";
        }
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String addUserToDB(@Valid Users users, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors() || usersService.isUserByUserName(users.getUserName())){
            return "registration";
        }else {
            usersService.saveNewUser(users);
            usersService.saveNewUserRole(users);
            model.addAttribute("new_user", users);
            return "registrationsuccess";
        }
    }



    // PROFILE

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if(Objects.nonNull(users)){
            model.addAttribute("userinfo", users);
            return "profile";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.POST)
    public String logOutFromAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/";
    }



    // ADMIN PAGES

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String viewAdminPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if(Objects.nonNull(usersService.getUserRolesByUser(users))){
            return "adminpage";
        }else{
            model.addAttribute("errortype", "accessdenied");
            return "errorpage";
        }
    }

}
