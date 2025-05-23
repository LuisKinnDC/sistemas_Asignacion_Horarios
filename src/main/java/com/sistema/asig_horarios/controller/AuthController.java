package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.model.Usuario;
import com.sistema.asig_horarios.service.UsuarioService;
import com.sistema.asig_horarios.utils.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(Usuario usuario) {
        if (usuario.getRol() == Rol.ADMIN) {
            usuario.setActivo(false); // Admin requiere aprobación manual
        } else {
            usuario.setActivo(true);
        }
        usuario.setAprobado(true); // Todos requieren aprobación
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Credenciales incorrectas o cuenta inactiva/no aprobada");
        }
        return "login";
    }
}
