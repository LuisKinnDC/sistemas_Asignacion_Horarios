package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    List<Docente> findByEspecialidad(String especialidad); // Buscar docentes por especialidad
}