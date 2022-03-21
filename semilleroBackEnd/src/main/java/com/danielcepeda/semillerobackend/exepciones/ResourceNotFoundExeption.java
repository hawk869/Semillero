package com.danielcepeda.semillerobackend.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Integer valorDelCampo;

    public ResourceNotFoundExeption(String nombreDelRecurso, String nombreDelCampo, Integer valorDelCampo) {
        super(String.format("%s no encontrado : %s : %s", nombreDelRecurso,nombreDelCampo,valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public Integer getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(Integer valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }
}
