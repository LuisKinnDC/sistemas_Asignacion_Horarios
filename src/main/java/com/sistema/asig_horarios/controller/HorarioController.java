package com.sistema.asig_horarios.controller;

import com.sistema.asig_horarios.model.HorarioClase;
import com.sistema.asig_horarios.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/horarios")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @GetMapping("/asignar")
    public String mostrarFormularioAsignacion(Model model) {
        model.addAttribute("horario", new HorarioClase());
        // Agregar listas de asignaturas, docentes, aulas, etc., al modelo
        return "asignar-horario";
    }

    @PostMapping("/asignar")
    public String procesarAsignacion(@ModelAttribute HorarioClase horario) {
        horarioService.asignarClase(horario);
        return "redirect:/admin/horarios";
    }
}