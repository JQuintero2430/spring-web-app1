package com.jorge.springboot.web.app1.controllers;

import com.jorge.springboot.web.app1.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/app"})
public class IndexController {
    @GetMapping({"/index","/", "", "home" })
    public String index(Model model) {
        model.addAttribute("title", "Hello Spring Framework!");
        model.addAttribute("h1", "Hello hello mi gente amada!");
        return "index";
    }

    @GetMapping({"/profile1"})
    public String profile(Model model){
        User user = new User("Jorge", "Gonzalez");
        model.addAttribute("user", user);
        model.addAttribute("title", "Perfil del usuario ".concat(user.getName()));
        model.addAttribute("h1", "Perfil del usuario ".concat(user.getName()
                                                                   .concat(" ")
                                                                   .concat(user.getSurname())));
        return "profile";
    }
}
