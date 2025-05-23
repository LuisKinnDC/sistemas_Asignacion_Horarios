package com.sistema.asig_horarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente docente;

    @Column(nullable = false)
    private String diaSemana;

    @ManyToOne
    @JoinColumn(name = "idTurno", nullable = false)
    private Turno turno;
}
