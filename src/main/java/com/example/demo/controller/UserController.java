package com.example.demo.controller;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    UserService userService;
//html bilgilerini spring e aktarılması 
    //web ile class iletişimi sağlanması
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }//

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegisterPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);

        if (result.hasErrors()) {//herhangi hatada tekrar kayıt sayfasına dönüyor
            return "register";
        } else {
            userService.saveUser(user);//kullanıcı kayıt için servise gönderiyoruz

        }
        return "home";
    }


    @RequestMapping("/")
    public String home() {//web sayfalarının yönlendirlmesi
        return "home";
    }

    @RequestMapping("/home")
    public String home2() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}