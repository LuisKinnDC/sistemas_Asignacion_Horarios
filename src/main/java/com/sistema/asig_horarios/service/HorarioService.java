package com.sistema.asig_horarios.service;

import com.sistema.asig_horarios.model.HorarioClase;
import com.sistema.asig_horarios.repository.HorarioClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    private HorarioClaseRepository horarioRepository;

    public boolean asignarClase(HorarioClase horario) {
        // Validar aula
        if (!horarioRepository.findConflictoAula(
                horario.getAula().getIdAula(),
                horario.getTurno().getIdTurno(),
                horario.getDiaSemana()
        ).isEmpty()) {
            throw new RuntimeException("El aula ya está ocupada");
        }

        // Validar docente
        if (!horarioRepository.findConflictoDocente(
                horario.getDocente().getIdDocente(),
                horario.getTurno().getIdTurno(),
                horario.getDiaSemana()
        ).isEmpty()) {
            throw new RuntimeException("El docente ya tiene clase asignada");
        }

        horarioRepository.save(horario);
        return true;
    }
}
