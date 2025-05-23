package com.sistema.asig_horarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurno;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    // Relación con HorarioClase (uno a muchos)
    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL)
    private List<HorarioClase> horarios;
}