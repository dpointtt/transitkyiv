package ua.com.transitkyiv.transitkyiv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.transitkyiv.transitkyiv.entity.Drivers;
import ua.com.transitkyiv.transitkyiv.entity.Stops;
import ua.com.transitkyiv.transitkyiv.entity.Users;
import ua.com.transitkyiv.transitkyiv.service.DriversService;
import ua.com.transitkyiv.transitkyiv.service.StopsService;
import ua.com.transitkyiv.transitkyiv.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class UsersController {

    // сервис пользователей
    private final UsersService usersService;
    private final DriversService driversService;
    private final StopsService stopsService;

    // свзяываем с контроллером
    @Autowired
    public UsersController(UsersService usersService,
                           DriversService driversService,
                           StopsService stopsService) {
        this.usersService = usersService;
        this.driversService = driversService;
        this.stopsService = stopsService;
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
    @GetMapping("/registration")
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
    @PostMapping("/registration")
    public String addUserToDB(Users users, Model model){
        // проверка на ошибки и на существование пользователя с таким же логином
        if(usersService.isUserByUserName(users.getUserName())){
            model.addAttribute("invalidInput", "Користувач с таким логіном вже існує");
            return "registration";
        } else if (users.getUserName().length() < 6) {
            model.addAttribute("invalidInput", "Логін має бути не менше 6 символів");
            return "registration";
        } else if (users.getTkpassword().length() < 6) {
            model.addAttribute("invalidInput", "Пароль має бути не менше 6 символів");
            return "registration";
        } else {
            // добавляем нового пользователя
            usersService.saveNewUser(users);
            // устанавливаем новому пользователю роль user
            usersService.saveNewUserRole(users, "user");
            // передаем пользователя
            model.addAttribute("new_user", users);
            return "registrationsuccess";
        }
    }

    // PROFILE

    // прослушивание страницы профиля
    @GetMapping("/profile")
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
    @PostMapping("/logout")
    public String logOutFromAccount(HttpServletRequest request){
        HttpSession session = request.getSession();
        // удаление аттрибута
        session.removeAttribute("user");
        return "redirect:/";
    }

    // ADMIN PAGES

    // прослушивание страницы для админов
    @GetMapping("/admin")
    public String viewAdminPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка на роль пользователя
        if(Objects.nonNull(usersService.checkAdmin(users))){
            model.addAttribute("users", usersService.getAllUsers());
            model.addAttribute("drivers", driversService.getAllDrivers());
            model.addAttribute("stops", stopsService.getAllStops());
            return "adminpage";
        }else{
            // при неудачной проверке отправляем страницу с ошибкой
            model.addAttribute("errortype", "accessdenied");
            return "errorpage";
        }
    }

    @PostMapping("/admin/add-user")
    public String addUser(String firstName,
                          String lastName,
                          String userName,
                          String userPassword,
                          String userRole,
                          HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        // проверка на роль пользователя
        if (Objects.nonNull(usersService.checkAdmin(users))) {
            if (!usersService.isUserByUserName(userName)) {
                // добавляем нового пользователя
                Users user = new Users(userName, firstName, lastName, userPassword);
                usersService.saveNewUser(user);
                // устанавливаем новому пользователю роль user
                usersService.saveNewUserRole(user, userRole);
            }
        }
        return "redirect:/admin";
    }

    @PostMapping("/admin/add-driver")
    public String addDriver(String firstName,
                            String lastName,
                            Integer age,
                            HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if (Objects.nonNull(usersService.checkAdmin(users))) {
            // добавляем нового водителя
            Drivers driver = new Drivers(firstName, lastName, age);
            driversService.save(driver);
            return "redirect:/admin";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/admin/add-stop")
    // add stop by stopAddress
    public String addStop(String stopAddress,
                          HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if (Objects.nonNull(usersService.checkAdmin(users)) && !stopsService.checkIfStopExists(stopAddress)) {
            // добавляем новую станцию
            Stops stop = new Stops(stopAddress);
            stopsService.save(stop);
            return "redirect:/admin";
        } else {
            return "redirect:/login";
        }
    }

}
