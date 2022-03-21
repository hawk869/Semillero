package com.danielcepeda.semillerobackend.DTO;

import com.danielcepeda.semillerobackend.entidades.numeradores.Disponible;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HacedorDTO {

    private Integer idHacedor;
    private String nombreCompleto;
    private String usuario;
    private Integer telefono;
    private Disponible disponible;
}
