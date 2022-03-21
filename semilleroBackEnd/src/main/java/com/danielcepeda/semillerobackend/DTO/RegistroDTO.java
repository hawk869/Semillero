package com.danielcepeda.semillerobackend.DTO;

import com.danielcepeda.semillerobackend.entidades.numeradores.ZonaCobertura;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroDTO {

    private Integer idRegistro;
    private ZonaCobertura cobertura;
    private String precio;


}
