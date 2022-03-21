package com.danielcepeda.semillerobackend.DTO;

import com.danielcepeda.semillerobackend.entidades.numeradores.EstadoTarea;
import com.danielcepeda.semillerobackend.entidades.numeradores.ZonaCobertura;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SolicitudDTO {

    private Integer idSolicitud;
    private String condiciones;
    private ZonaCobertura cobertura;
    private Integer precio;
    private EstadoTarea estadoTarea;
}
