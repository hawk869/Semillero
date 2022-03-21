package com.danielcepeda.semillerobackend.entidades;

import com.danielcepeda.semillerobackend.entidades.numeradores.ZonaCobertura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "perfil_hacedor")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;
    @Column
    @Enumerated(EnumType.STRING)
    private ZonaCobertura cobertura;
    @Column
    private String precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tarea",
            foreignKey = @ForeignKey(name = "FK_ID_TAREA")
    )
    private Tarea tarea;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            unique = true,
            name = "id_hacedor",
            foreignKey = @ForeignKey(name = "FK_ID_HACEDOR")
    )
    private Hacedor hacedor;
}
