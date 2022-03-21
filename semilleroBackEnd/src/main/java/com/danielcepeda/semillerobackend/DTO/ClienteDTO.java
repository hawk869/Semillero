package com.danielcepeda.semillerobackend.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ClienteDTO {

    private Integer idCliente;
    private String nombreCompleto;
    private String usuario;
    private Integer telefono;
}
