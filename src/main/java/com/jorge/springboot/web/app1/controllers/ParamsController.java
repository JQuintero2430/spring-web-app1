package com.jorge.springboot.web.app1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/params"})
public class ParamsController {
    @GetMapping({"/index"})
    public String index() {
        return "params/index";
    }
    @GetMapping({"/text", "/"})
    public String text(@RequestParam String text, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + text);
        return "params/text";
    }

    @GetMapping({"/mix-params"})
    public String mixParams(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("resultado", "El saludo enviado es: " + saludo + " y el número es " + numero + ".");
        return "params/text";
    }

    @GetMapping({"/mix-params-english"})
    public String paramsRequest(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException ignored) {

        }
        model.addAttribute("resultado", "El saludo enviado es: " + saludo + " y el número es " + numero + ".");
        return "params/text";
    }

    @ModelAttribute("title")
    public String title(){
        return "Recibir parámetros del request HTTP GET";
    }
}
