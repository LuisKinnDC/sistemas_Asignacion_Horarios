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
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;

    @ManyToOne
    @JoinColumn(name = "idPrograma", nullable = false)
    private Programa programa;

    @Column(nullable = false)
    private String nombre;

    private String codigo;
    private Integer creditos;

    // Relación con RequisitoAula (uno a muchos)
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<RequisitoAula> requisitosAula;

    // Relación con HorarioClase (uno a muchos)
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<HorarioClase> horarios;
}