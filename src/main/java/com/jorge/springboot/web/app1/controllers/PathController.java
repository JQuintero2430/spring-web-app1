package com.jorge.springboot.web.app1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/path"})
public class PathController {

    @GetMapping({"/text/{text}"})
    public String path(@PathVariable String text, Model model) {
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + text);
        return "path/text";
    }

    @ModelAttribute("title")
    public String title(){
        return "Recibir parámetros de la ruta con @PathVariable";
    }
}
