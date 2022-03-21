package com.danielcepeda.semillerobackend.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;
    @Column
    private String nombreTarea;
    @OneToMany(
            mappedBy = "tarea",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Registro> registro;
    @OneToMany(
            mappedBy = "solicitudTarea",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Solicitud> solicitudes;
}
