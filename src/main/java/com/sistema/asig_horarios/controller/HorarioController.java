package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.model.HorarioClase;
import com.sistema.asig_horarios.repository.AsignaturaRepository;
import com.sistema.asig_horarios.repository.AulaRepository;
import com.sistema.asig_horarios.repository.DocenteRepository;
import com.sistema.asig_horarios.repository.TurnoRepository;
import com.sistema.asig_horarios.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    // Mostrar lista de horarios
    @GetMapping
    public String listarHorarios(Model model) {
        List<HorarioClase> horarios = horarioService.listarHorarios();
        model.addAttribute("horarios", horarios);
        return "admin/gestion-horarios";
    }

    // Mostrar formulario para asignar un nuevo horario
    @GetMapping("/nuevo")
    public String mostrarFormularioAsignacion(Model model) {
        model.addAttribute("horario", new HorarioClase());
        model.addAttribute("asignaturas", asignaturaRepository.findAll());
        model.addAttribute("docentes", docenteRepository.findAll());
        model.addAttribute("aulas", aulaRepository.findAll());
        model.addAttribute("turnos", turnoRepository.findAll());
        return "admin/nuevo-horario";
    }

    // Procesar asignación de horario
    @PostMapping("/asignar")
    public String procesarAsignacion(@ModelAttribute HorarioClase horario, Model model) {
        try {
            horarioService.asignarHorario(horario);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "admin/nuevo-horario"; // Muestra el formulario con el mensaje de error
        }
        return "redirect:/admin/horarios";
    }
}