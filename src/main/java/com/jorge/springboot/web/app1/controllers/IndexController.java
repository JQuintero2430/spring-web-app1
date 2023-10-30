package com.jorge.springboot.web.app1.controllers;

import com.jorge.springboot.web.app1.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping({"/app"})
public class IndexController {

    @Value("${text.indexController.title}")
    private String titleIndex;

    @Value("${text.indexController.h1}")
    private String titleIndexH1;

    @Value("${text.profileController.title}")
    private String titleProfile;

    @Value("${text.profileController.h1}")
    private String titleProfileH1;

    @Value("${text.listarController.title}")
    private String titleListar;

    @GetMapping({"/index","/", "", "home" })
    public String index(Model model) {
        model.addAttribute("title", titleIndex);
        model.addAttribute("h1", titleIndexH1);
        return "index";
    }

    @GetMapping({"/profile1"})
    public String profile(Model model){
        User user = new User("Jorge", "Gonzalez", "jorge@correo.com");
        model.addAttribute("user", user);
        model.addAttribute("title", titleProfile.concat(user.getName()));
        model.addAttribute("h1", titleProfileH1.concat(user.getName()
                                                                   .concat(" ")
                                                                   .concat(user.getSurname())));
        return "profile";
    }

    @GetMapping({"/listar"})
    public String listar(Model model){
        model.addAttribute("title", titleListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<User> fillUsers() {
        return Arrays.asList(
                new User("Jorge", "Gonzalez", "jorge@correo.com"),
                new User("John", "Doe", "john@correo.com"),
                new User("jane", "Lynch", "jane@correo.com"),
                new User("Ray", "Charles", "ray@correo.com"));
    }
}
