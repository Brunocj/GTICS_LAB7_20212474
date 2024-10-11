package com.example.lab7gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GerenteController {

    @GetMapping({"Gerente/Reervas"})
    public String proyecciones(Model model) {

        return "Gerente/Reservas";
    }

    @GetMapping({"Gerente/Proyecciones"})
    public String salas(Model model) {

        return "Gerente/Proyecciones";
    }
}
