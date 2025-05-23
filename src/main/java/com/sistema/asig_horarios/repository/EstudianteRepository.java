package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByProgramaIdPrograma(Integer idPrograma);
}
