package com.sistema.asig_horarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrograma;

    @ManyToOne
    @JoinColumn(name = "idUnidad", nullable = false)
    private UnidadAcademica unidadAcademica;

    @Column(nullable = false)
    private String nombre;

    private String nivel;

    // Relación con Asignatura (uno a muchos)
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas;

    // Relación con Estudiante (uno a muchos)
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;
}