package com.sistema.asig_horarios.repository;

import com.sistema.asig_horarios.model.HorarioClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioClaseRepository extends JpaRepository<HorarioClase, Integer> {

    // Verificar si un aula ya está ocupada
    @Query("SELECT h FROM HorarioClase h WHERE h.aula.idAula = :idAula AND h.turno.idTurno = :idTurno AND h.diaSemana = :dia")
    List<HorarioClase> findConflictoAula(@Param("idAula") Integer idAula,
                                         @Param("idTurno") Integer idTurno,
                                         @Param("dia") String dia);

    // Verificar si un docente ya tiene clase asignada
    @Query("SELECT h FROM HorarioClase h WHERE h.docente.idDocente = :idDocente AND h.turno.idTurno = :idTurno AND h.diaSemana = :dia")
    List<HorarioClase> findConflictoDocente(@Param("idDocente") Integer idDocente,
                                            @Param("idTurno") Integer idTurno,
                                            @Param("dia") String dia);
}