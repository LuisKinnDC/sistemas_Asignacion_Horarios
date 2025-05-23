package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    // Métodos personalizados pueden ir aquí (si son necesarios)
}
