package com.sistema.asig_horarios.service;

import com.sistema.asig_horarios.model.HorarioClase;
import com.sistema.asig_horarios.repository.HorarioClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioClaseRepository horarioRepository;

    // Asignar un nuevo horario
    public void asignarHorario(HorarioClase horario) {
        // Validar que el aula no esté ocupada
        if (!horarioRepository.findConflictoAula(
                horario.getAula().getIdAula(),
                horario.getTurno().getIdTurno(),
                horario.getDiaSemana()
        ).isEmpty()) {
            throw new RuntimeException("El aula ya está ocupada en este horario.");
        }

        // Validar que el docente no tenga otro horario asignado
        if (!horarioRepository.findConflictoDocente(
                horario.getDocente().getIdDocente(),
                horario.getTurno().getIdTurno(),
                horario.getDiaSemana()
        ).isEmpty()) {
            throw new RuntimeException("El docente ya tiene clase asignada en este horario.");
        }

        // Guardar el horario
        horarioRepository.save(horario);
    }

    // Listar todos los horarios
    public List<HorarioClase> listarHorarios() {
        return horarioRepository.findAll();
    }
}
