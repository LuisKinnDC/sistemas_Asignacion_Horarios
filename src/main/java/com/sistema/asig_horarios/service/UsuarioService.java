package com.sistema.asig_horarios.service;

import com.sistema.asig_horarios.model.Usuario;
import com.sistema.asig_horarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registrar un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }

    // Buscar un usuario por email
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Validar contraseña
    public boolean validarContrasenia(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    // Obtener usuarios pendientes de aprobación
    public List<Usuario> obtenerUsuariosPendientes() {
        return usuarioRepository.findByAprobado(false);
    }

    // Obtener usuarios aprobados
    public List<Usuario> obtenerUsuariosAprobados() {
        return usuarioRepository.findByAprobado(true);
    }

    // Aprobar un usuario
    public void aprobarUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setAprobado(true);
            usuarioRepository.save(usuario);
        });
    }

    // Activar un usuario
    public void activarUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setActivo(true); // Marcar como activo
            usuario.setAprobado(true); // Marcar como aprobado
            usuarioRepository.save(usuario);
        });
    }

    // Desactivar un usuario
    public void desactivarUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setActivo(false);
            usuarioRepository.save(usuario);
        });
    }

    // Rechazar un usuario
    public void rechazarUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setActivo(false); // Marcar como inactivo
            usuario.setAprobado(false); // Marcar como no aprobado
            usuarioRepository.save(usuario);
        });
    }

    // Eliminar un usuario
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    // Cambiar estado de un usuario (alternar entre activo/inactivo)
    public void cambiarEstadoUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setActivo(!usuario.isActivo()); // Alternar estado
            usuarioRepository.save(usuario);
        });
    }

    // Listar usuarios pendientes de activación
    public List<Usuario> listarUsuariosPendientesActivacion() {
        return usuarioRepository.findByActivo(false);
    }

    // Listar usuarios aprobados y activos
    public List<Usuario> listarUsuariosAprobadosActivos() {
        return usuarioRepository.findByActivoAndAprobado(true, true);
    }

    // Listar usuarios rechazados
    public List<Usuario> listarUsuariosRechazados() {
        return usuarioRepository.findByAprobadoAndActivo(false, false);
    }

    public long contarUsuarios() {
        return usuarioRepository.count();
    }

}