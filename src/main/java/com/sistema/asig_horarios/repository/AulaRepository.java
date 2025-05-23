package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
    // Métodos personalizados pueden ir aquí (si son necesarios)
}
