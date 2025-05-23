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
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAula;

    @ManyToOne
    @JoinColumn(name = "idPabellon", nullable = false)
    private Pabellon pabellon;

    @Column(nullable = false)
    private String numero;

    private Integer capacidadMaxima = 45;
    private String tipo;

    // Relación con HorarioClase (uno a muchos)
    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    private List<HorarioClase> horarios;
}
