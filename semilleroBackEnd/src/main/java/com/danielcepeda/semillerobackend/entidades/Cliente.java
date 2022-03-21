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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(length = 40)
    private String nombreCompleto;
    @Column(length = 15, unique = true)
    private String usuario;
    @Column(unique = true, length = 10)
    private Integer telefono;
    @OneToMany(
            mappedBy = "cliente",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private Set<Solicitud> solicitud;
}
