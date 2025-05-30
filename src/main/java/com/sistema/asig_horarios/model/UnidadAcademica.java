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
public class UnidadAcademica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidad;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String descripcion;

    // Relación con Programa (uno a muchos)
    @OneToMany(mappedBy = "unidadAcademica", cascade = CascadeType.ALL)
    private List<Programa> programas;
}
