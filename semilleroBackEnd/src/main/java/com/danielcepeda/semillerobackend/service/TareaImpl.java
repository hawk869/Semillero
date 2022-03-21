package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.TareaDTO;
import com.danielcepeda.semillerobackend.entidades.Tarea;
import com.danielcepeda.semillerobackend.exepciones.ResourceNotFoundExeption;
import com.danielcepeda.semillerobackend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    @Transactional
    public TareaDTO crearTarea(TareaDTO tareaDTO) {
        Tarea tarea = mapearEntidad(tareaDTO);
        Tarea nuevaTarea = tareaRepository.save(tarea);
        TareaDTO tareaRespuesta = mapearDTO(nuevaTarea);
        return tareaRespuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public TareaDTO buscarTareaPorId(Integer id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Tarea","id",id));
        return mapearDTO(tarea);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TareaDTO> obtenerTareas() {
        List<Tarea> tareaList = tareaRepository.findAll();
        return tareaList.stream().map(tarea -> mapearDTO(tarea)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TareaDTO actualizarTarea(TareaDTO tareaDTO, Integer id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Tarea","id", id));
        tarea.setNombreTarea(tareaDTO.getNombreTarea());
        return mapearDTO(tareaRepository.save(tarea));
    }

    @Override
    @Transactional
    public void borrarTarea(Integer id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Tarea","id",id));
        tareaRepository.delete(tarea);

    }

    private TareaDTO mapearDTO (Tarea tarea){

        TareaDTO tareaDTO = new TareaDTO();
        tareaDTO.setIdTarea(tarea.getIdTarea());
        tareaDTO.setNombreTarea(tarea.getNombreTarea());

        return tareaDTO;
    }
    private Tarea mapearEntidad (TareaDTO dto){

        Tarea tarea = new Tarea();
        tarea.setIdTarea(dto.getIdTarea());
        tarea.setNombreTarea(dto.getNombreTarea());

        return tarea;
    }
}
