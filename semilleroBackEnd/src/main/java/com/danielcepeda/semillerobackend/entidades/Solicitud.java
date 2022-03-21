package com.danielcepeda.semillerobackend.entidades;

import com.danielcepeda.semillerobackend.entidades.numeradores.EstadoTarea;
import com.danielcepeda.semillerobackend.entidades.numeradores.ZonaCobertura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;
    @Column
    private String condiciones;
    @Column
    @Enumerated(EnumType.STRING)
    private ZonaCobertura cobertura;
    @Column
    private Integer precio;
    @Column
    @Enumerated(EnumType.STRING)
    private EstadoTarea estadoTarea;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_cliente",
            foreignKey = @ForeignKey(name = "FK_ID_CLIENTE")
    )
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tarea",
            foreignKey = @ForeignKey(name = "FK_TAREA_ID")
    )
    private Tarea solicitudTarea;
}
