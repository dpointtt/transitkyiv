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

    // сервис пользователей
    private final UsersService usersService;

    // свзяываем с контроллером
    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    // LOGIN

    // прослушивание страницы входа
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка пользователя
        // если пользователь уже вошел, он не может зайти еще раз
        if(Objects.nonNull(users)){
            return "redirect:/";
        }else {
            return "login";
        }
    }

    // обработка входа пользователя
    // параметры пароль и логин
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String getUserFromDB(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        // проверка существует ли такой пользователь
        if(usersService.isUser(username, password)){
            // добавляем атрибут в текущую сессию
            // по которому будем проверять пользователя в других методах
            session.setAttribute("user", usersService.getUser(username));
            // передаем пользователя на страницу успешного входа
            model.addAttribute("user_", usersService.getUser(username));
            return "loginsuccess";
        }else{
            return "redirect:/login";
        }

    }

    // REGISTRATION

    // прослушивание страницы регистрации
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String getRegPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка пользователя
        // если пользователь уже вошел, он не может зарегистрироваться
        if(Objects.nonNull(users)){
            return "redirect:/";
        }else {
            // передаем нового пользователя
            model.addAttribute("tkusers", new Users());
            return "registration";
        }
    }

    // обработка регистрации пользователя
    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String addUserToDB(@Valid Users users, BindingResult bindingResult, Model model){
        // проверка на ошибки и на существование пользователя с таким же логином
        if(bindingResult.hasErrors() || usersService.isUserByUserName(users.getUserName())){
            return "registration";
        }else {
            // добавляем нового пользователя
            usersService.saveNewUser(users);
            // устанавливаем новому пользователю роль user
            usersService.saveNewUserRole(users);
            // передаем пользователя
            model.addAttribute("new_user", users);
            return "registrationsuccess";
        }
    }

    // PROFILE

    // прослушивание страницы профиля
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка пользователя
        if(Objects.nonNull(users)){
            // передаем пользователя
            model.addAttribute("userinfo", users);
            return "profile";
        }else{
            return "redirect:/login";
        }
    }

    // обработка выхода из профиля
    // происходит удаление аттрибута сессии
    @RequestMapping(value = {"/profile"}, method = RequestMethod.POST)
    public String logOutFromAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        // удаление аттрибута
        session.removeAttribute("user");
        return "redirect:/";
    }

    // ADMIN PAGES

    // прослушивание страницы для админов
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String viewAdminPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка на роль пользователя
        if(Objects.nonNull(usersService.getUserRolesByUser(users))){
            return "adminpage";
        }else{
            // при неудачной проверке отправляем страницу с ошибкой
            model.addAttribute("errortype", "accessdenied");
            return "errorpage";
        }
    }

}
