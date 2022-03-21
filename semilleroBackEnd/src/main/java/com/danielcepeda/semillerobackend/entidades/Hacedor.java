package com.danielcepeda.semillerobackend.entidades;

import com.danielcepeda.semillerobackend.entidades.numeradores.Disponible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hacedores")
public class Hacedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHacedor;
    @Column(length = 40)
    private String nombreCompleto;
    @Column(length = 15, unique = true)
    private String usuario;
    @Column(unique = true, length = 10)
    private Integer telefono;
    @Column
    @Enumerated(EnumType.STRING)
    private Disponible disponible;
    @OneToOne(
            mappedBy = "hacedor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Registro registro;
}
