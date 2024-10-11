package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Obra;
import com.example.lab7gtics.repository.ObraRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteController {

    private final ObraRepository obraRepository;

    public ClienteController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @GetMapping({ "Cliente/Peliculas"})
    public String peliculas(Model model) {
        List<Obra> listaObras =  obraRepository.findAll();

        model.addAttribute("obras", listaObras);
        return "Cliente/peliculas";
    }
    @GetMapping({"Cliente", "Cliente/MisReservas"})
    public String misReservas(Model model) {

        return "Cliente/MisReservas";
    }
}
