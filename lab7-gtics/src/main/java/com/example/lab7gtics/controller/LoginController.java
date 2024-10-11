package com.example.lab7gtics.controller;

import com.example.lab7gtics.entity.Role;
import com.example.lab7gtics.entity.User;
import com.example.lab7gtics.repository.RoleRepository;
import com.example.lab7gtics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    //No funciona el login, el register si crea al usuario en la db
    @GetMapping("/openLoginWindow")
    public String loginWindow(Model model){
        User u = new User();
        model.addAttribute("usuario", u);
        return "loginWindow";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        User u = new User();
        model.addAttribute("usuario", u);
        return "register";
    }

    @PostMapping("/registerPOST")
    public String register(@ModelAttribute User usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Role rol = roleRepository.getReferenceById(8);
        usuario.setRole(rol);
        usuarioRepository.save(usuario);
        return "redirect:/openLoginWindow";
    }
}
