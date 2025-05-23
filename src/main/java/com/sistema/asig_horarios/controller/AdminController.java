package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pendientes", usuarioService.obtenerUsuariosPendientes());
        return "admin/dashboard";
    }

    @PostMapping("/admin/aprobar")
    public String aprobarUsuario(@RequestParam Integer id) {
        usuarioService.aprobarUsuario(id);
        return "redirect:/admin/dashboard";
    }
}
