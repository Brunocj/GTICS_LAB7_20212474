package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Obra;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @GetMapping({"Admin", "Admin/Peliculas"})
    public String peliculas(Model model) {

        return "Admin/Peliculas";
    }
    @GetMapping({"Admin/Salas"})
    public String salas(Model model) {

        return "Admin/Salas";
    }

    @GetMapping({"Admin/Proyecciones"})
    public String proyecciones(Model model) {

        return "Admin/Proyecciones";
    }
}
