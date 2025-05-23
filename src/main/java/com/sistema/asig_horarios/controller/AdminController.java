package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.model.Usuario;
import com.sistema.asig_horarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        // Usuarios pendientes de aprobación
        List<Usuario> usuariosPendientes = usuarioService.obtenerUsuariosPendientes();
        model.addAttribute("usuariosPendientes", usuariosPendientes);

        return "admin/dashboard";
    }

    @PostMapping("/aprobar")
    public String aprobarUsuario(@RequestParam Integer idUsuario) {
        usuarioService.aprobarUsuario(idUsuario);
        return "redirect:/admin/dashboard";
    }
}
