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
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String email;

    private String especialidad;
    private Integer maxHorasSemanales = 20;

    // Relación con DisponibilidadDocente (uno a muchos)
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private List<DisponibilidadDocente> disponibilidades;

    // Relación con HorarioClase (uno a muchos)
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private List<HorarioClase> horarios;
}
