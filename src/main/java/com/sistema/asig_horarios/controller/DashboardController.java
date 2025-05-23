package com.sistema.asig_horarios.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        // Obtener el email del usuario autenticado
        String email = authentication.getName();
        model.addAttribute("email", email);

        // Obtener el rol del usuario
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("role", role);

        // Personalizar vista según el rol
        if (role.equals("ROLE_ADMIN")) {
            return "admin/dashboard";
        } else if (role.equals("ROLE_DOCENTE")) {
            return "docente/dashboard";
        } else if (role.equals("ROLE_ESTUDIANTE")) {
            return "estudiante/dashboard";
        }

        // Si no hay rol válido, redirigir al login
        return "redirect:/login";
    }
}