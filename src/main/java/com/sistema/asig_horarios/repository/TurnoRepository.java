package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    // Métodos personalizados pueden ir aquí (si son necesarios)
}
