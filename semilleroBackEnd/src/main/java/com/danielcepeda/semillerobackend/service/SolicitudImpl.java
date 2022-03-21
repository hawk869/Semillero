package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.SolicitudDTO;
import com.danielcepeda.semillerobackend.entidades.Cliente;
import com.danielcepeda.semillerobackend.entidades.Solicitud;
import com.danielcepeda.semillerobackend.entidades.Tarea;
import com.danielcepeda.semillerobackend.exepciones.ResourceNotFoundExeption;
import com.danielcepeda.semillerobackend.repository.ClienteRepository;
import com.danielcepeda.semillerobackend.repository.SolicitudRespository;
import com.danielcepeda.semillerobackend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudImpl implements SolicitudService{

    @Autowired
    private SolicitudRespository solicitudRespository;
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public SolicitudDTO crearSolicitud(SolicitudDTO solicitudDTO, Integer idCliente, Integer idTarea) {

        Tarea tarea = tareaRepository.findById(idTarea)
                .orElseThrow(()->new ResourceNotFoundExeption("Tarea","idTarea",idTarea));
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()->new ResourceNotFoundExeption("Cliente","idCliente", idCliente));

        Solicitud solicitud = mapearEntidad(solicitudDTO);
        solicitud.setSolicitudTarea(tarea);
        solicitud.setCliente(cliente);
        return mapearDTO(solicitudRespository.save(solicitud));
        }

    @Override
    @Transactional(readOnly = true)
    public List<SolicitudDTO> buscarSolicitudPorIdCliente(Integer idCliente) {
        List<Solicitud> solicituds = solicitudRespository.findByCliente_IdCliente(idCliente);
        return solicituds.stream().map(solicitud -> mapearDTO(solicitud)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SolicitudDTO> buscarSolicitudPorIdTarea(Integer idTarea) {
        List<Solicitud> solicituds = solicitudRespository.findBySolicitudTareaIdTarea(idTarea);
        return solicituds.stream().map(solicitud -> mapearDTO(solicitud)).collect(Collectors.toList());
    }

    private SolicitudDTO mapearDTO(Solicitud solicitud){
        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setIdSolicitud(solicitud.getIdSolicitud());
        solicitudDTO.setCondiciones(solicitud.getCondiciones());
        solicitudDTO.setCobertura(solicitud.getCobertura());
        solicitudDTO.setPrecio(solicitud.getPrecio());
        solicitudDTO.setEstadoTarea(solicitud.getEstadoTarea());
        return solicitudDTO;
    }
    private Solicitud mapearEntidad(SolicitudDTO solicitudDTO){
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(solicitudDTO.getIdSolicitud());
        solicitud.setCondiciones(solicitudDTO.getCondiciones());
        solicitud.setPrecio(solicitudDTO.getPrecio());
        solicitud.setCobertura(solicitudDTO.getCobertura());
        solicitud.setEstadoTarea(solicitudDTO.getEstadoTarea());
        return solicitud;
    }


}
