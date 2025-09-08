package com.e_pass.proj_integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html no templates
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // home.html no templates
    }
}