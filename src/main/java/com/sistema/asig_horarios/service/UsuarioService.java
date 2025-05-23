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

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean validarContrasenia(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public List<Usuario> obtenerUsuariosPendientes() {
        return usuarioRepository.findByAprobado(false);
    }

    public List<Usuario> obtenerUsuariosAprobados() {
        return usuarioRepository.findByAprobado(true);
    }

    public void aprobarUsuario(Integer idUsuario) {
        usuarioRepository.findById(idUsuario).ifPresent(usuario -> {
            usuario.setAprobado(true);
            usuario.setActivo(true);
            usuarioRepository.save(usuario);
        });
    }
}
