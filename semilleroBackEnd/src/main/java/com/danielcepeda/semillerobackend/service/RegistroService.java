package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.RegistroDTO;

import java.util.List;

public interface RegistroService {

    public RegistroDTO crearRegistro(RegistroDTO registroDTO, Integer idHacedor, Integer idTarea);
    public RegistroDTO buscarRegistroPorId (Integer id);
    public List<RegistroDTO> obtenerRegistros();
    public RegistroDTO actualizarRegistro (RegistroDTO registroDTO, Integer id, Integer idTarea);
    public void borrarRegistro (Integer id);
    public List<RegistroDTO> buscarRegistroPorTareaId(Integer idTarea);
    public List<RegistroDTO> buscarRegistroPorHacedorID(Integer idHacedor);
}
