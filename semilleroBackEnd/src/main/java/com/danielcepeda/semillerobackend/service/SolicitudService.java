package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.SolicitudDTO;

import java.util.List;

public interface SolicitudService {

    public SolicitudDTO crearSolicitud (SolicitudDTO solicitudDTO, Integer idCliente, Integer idTarea);
    public List<SolicitudDTO> buscarSolicitudPorIdCliente(Integer idCliente);
    public List<SolicitudDTO> buscarSolicitudPorIdTarea(Integer idTarea);
//    public RegistroDTO buscarRegistroPorId (Integer id);
//    public List<RegistroDTO> obtenerRegistros();
//    public RegistroDTO actualizarRegistro (RegistroDTO registroDTO, Integer id, Integer idTarea);
//    public void borrarRegistro (Integer id);

}
