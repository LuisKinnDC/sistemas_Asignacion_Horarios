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
public class Pabellon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPabellon;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String ubicacion;

    // Relación con Aula (uno a muchos)
    @OneToMany(mappedBy = "pabellon", cascade = CascadeType.ALL)
    private List<Aula> aulas;
}
