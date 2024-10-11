package com.example.lab7gtics.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String redirectUrl = determineRedirectUrl(authentication);
        response.sendRedirect(redirectUrl);
    }

    private String determineRedirectUrl(Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "/Admin/Peliculas";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("GERENTE"))) {
            return "/Gerente/Reservas";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENTE"))) {
            return "/Cliente/Peliculas";

        } else {
            return "/default";
        }
    }
}
