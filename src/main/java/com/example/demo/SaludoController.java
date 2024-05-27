package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaludoController {

    @GetMapping("/")
    public String saludar() {
        return "saludo"; // Devuelve el nombre de la vista (sin la extensión)
    }
    
    @PostMapping("/")
    public String mostrarsaludo() {
        return "mensaje"; // Devuelve el nombre de la vista (sin la extensión)
    }
}