package com.sistema.asig_horarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "HorarioClase",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_Aula_Turno_Dia",
                        columnNames = {"idAula", "idTurno", "diaSemana"}
                ),
                @UniqueConstraint(
                        name = "UK_Docente_Turno_Dia",
                        columnNames = {"idDocente", "idTurno", "diaSemana"}
                )
        }
)
public class HorarioClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @ManyToOne
    @JoinColumn(name = "idAsignatura", nullable = false)
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "idAula", nullable = false)
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "idTurno", nullable = false)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "idUnidad", nullable = false)
    private UnidadAcademica unidadAcademica;

    @Column(nullable = false)
    private String diaSemana;
}