package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Usuario;
import com.sistema.asig_horarios.utils.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar un usuario por email
    Optional<Usuario> findByEmail(String email);

    // Filtrar usuarios por estado de aprobación
    List<Usuario> findByAprobado(Boolean aprobado);

    // Filtrar usuarios por estado de activación
    List<Usuario> findByActivo(Boolean activo);

    // Filtrar usuarios por estado de activación y aprobación
    List<Usuario> findByActivoAndAprobado(Boolean activo, Boolean aprobado);

    // Listar usuarios rechazados
    List<Usuario> findByAprobadoAndActivo(Boolean aprobado, Boolean activo);

    // Listar todos los usuarios
    List<Usuario> findAll();
}
