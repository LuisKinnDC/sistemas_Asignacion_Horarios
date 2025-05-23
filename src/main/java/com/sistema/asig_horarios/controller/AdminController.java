package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.model.Usuario;
import com.sistema.asig_horarios.repository.UsuarioRepository;
import com.sistema.asig_horarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    // Gestionar Usuarios
    @GetMapping("/usuarios")
    public String gestionarUsuarios(Model model) {

        // Obtener usuarios pendientes de activación
        List<Usuario> usuariosPendientesActivacion = usuarioService.listarUsuariosPendientesActivacion();
        model.addAttribute("usuariosPendientesActivacion", usuariosPendientesActivacion);

        // Obtener todos los usuarios aprobados y activos
        List<Usuario> usuariosAprobadosActivos = usuarioService.listarUsuariosAprobadosActivos();
        model.addAttribute("usuariosAprobadosActivos", usuariosAprobadosActivos);

        // Obtener usuarios rechazados
        List<Usuario> usuariosRechazados = usuarioService.listarUsuariosRechazados();
        model.addAttribute("usuariosRechazados", usuariosRechazados);

        return "admin/gestion-usuarios"; // Vista específica para gestionar usuarios
    }

    // Activar un usuario
    @PostMapping("/activar")
    public String activarUsuario(@RequestParam Integer idUsuario) {
        usuarioService.activarUsuario(idUsuario);
        return "redirect:/admin/usuarios";
    }

    // Rechazar un usuario
    @PostMapping("/rechazar")
    public String rechazarUsuario(@RequestParam Integer idUsuario) {
        usuarioService.rechazarUsuario(idUsuario);
        return "redirect:/admin/usuarios";
    }

    // Cambiar estado de un usuario (alternar entre activo/inactivo)
    @PostMapping("/usuarios/cambiar-estado/{idUsuario}")
    public String cambiarEstadoUsuario(@PathVariable Integer idUsuario) {
        usuarioService.cambiarEstadoUsuario(idUsuario);
        return "redirect:/admin/usuarios";
    }

    // Eliminar un usuario rechazado
    @PostMapping("/eliminar-rechazado")
    public String eliminarRechazado(@RequestParam Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return "redirect:/admin/usuarios";
    }
}