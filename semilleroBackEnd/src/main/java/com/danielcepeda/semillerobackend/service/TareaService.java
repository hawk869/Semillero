package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.HacedorDTO;
import com.danielcepeda.semillerobackend.DTO.TareaDTO;
import com.danielcepeda.semillerobackend.entidades.Tarea;

import java.util.List;

public interface TareaService {

    public TareaDTO crearTarea(TareaDTO tareaDTO);
    public TareaDTO buscarTareaPorId (Integer id);
    public List<TareaDTO> obtenerTareas();
    public TareaDTO actualizarTarea (TareaDTO tareaDTO, Integer id);
    public void borrarTarea (Integer id);
}
