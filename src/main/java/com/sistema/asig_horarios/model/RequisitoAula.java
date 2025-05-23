package com.sistema.asig_horarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequisitoAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRequisito;

    @ManyToOne
    @JoinColumn(name = "idAsignatura", nullable = false)
    private Asignatura asignatura;

    @Column(nullable = false)
    private String tipoAulaRequerido;
}
