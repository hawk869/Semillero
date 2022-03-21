package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.RegistroDTO;
import com.danielcepeda.semillerobackend.entidades.Hacedor;
import com.danielcepeda.semillerobackend.entidades.Registro;
import com.danielcepeda.semillerobackend.entidades.Tarea;
import com.danielcepeda.semillerobackend.exepciones.ResourceNotFoundExeption;
import com.danielcepeda.semillerobackend.repository.HacedorRepository;
import com.danielcepeda.semillerobackend.repository.RegistroRepository;
import com.danielcepeda.semillerobackend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RegistroImpl implements RegistroService{

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private HacedorRepository hacedorRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    @Transactional
    public RegistroDTO crearRegistro(RegistroDTO registroDTO, Integer idHacedor, Integer idTarea) {

        Hacedor hacedor = hacedorRepository.findById(idHacedor)
                .orElseThrow(()->new ResourceNotFoundExeption("Hacedor","idHacedor",idHacedor));
        Tarea tarea = tareaRepository.findById(idTarea)
                .orElseThrow(()->new ResourceNotFoundExeption("Tarea","idTarea",idTarea));
        Registro registro = mapearEntidad(registroDTO);
        registro.setHacedor(hacedor);
        registro.setTarea(tarea);

        return mapearDto(registroRepository.save(registro));
    }

    @Override
    @Transactional(readOnly = true)
    public RegistroDTO buscarRegistroPorId(Integer id) {
        Registro registro = registroRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Registro","id",id));
        return mapearDto(registro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> obtenerRegistros() {
        List<Registro> registroList = registroRepository.findAll();
        return registroList.stream().map(registro -> mapearDto(registro)).collect(Collectors.toList());
    }

    @Override
    public RegistroDTO actualizarRegistro(RegistroDTO registroDTO, Integer id, Integer idTarea) {
        Registro registro = registroRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Registro","id", id));
        Tarea tarea = tareaRepository.findById(idTarea)
                        .orElseThrow(()->new ResourceNotFoundExeption("Tarea","idTarea", idTarea));
        registro.setPrecio(registroDTO.getPrecio());
        registro.setCobertura(registroDTO.getCobertura());
        registro.setPrecio(registroDTO.getPrecio());
        registro.setTarea(tarea);
        registroRepository.save(registro);
        return mapearDto(registro);
    }

    @Override
    @Transactional
    public void borrarRegistro(Integer id) {
        Registro registro = registroRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Registro", "id", id));
        registroRepository.delete(registro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> buscarRegistroPorTareaId(Integer idTarea) {
        List<Registro> registros = registroRepository.findByTareaIdTarea(idTarea);
        return registros.stream().map(registro -> mapearDto(registro)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> buscarRegistroPorHacedorID(Integer idHacedor) {
        List<Registro> registros = registroRepository.findByHacedor_IdHacedor(idHacedor);
        return registros.stream().map(registro -> mapearDto(registro)).collect(Collectors.toList());
    }


    private RegistroDTO mapearDto (Registro registro){
        RegistroDTO registroDTO = new RegistroDTO();
        registroDTO.setIdRegistro(registro.getIdRegistro());
        registroDTO.setPrecio(registro.getPrecio());
        registroDTO.setCobertura(registro.getCobertura());

        return registroDTO;
    }
    private Registro mapearEntidad (RegistroDTO registroDTO){
        Registro registro = new Registro();
        registro.setIdRegistro(registroDTO.getIdRegistro());
        registro.setPrecio(registroDTO.getPrecio());
        registro.setCobertura(registroDTO.getCobertura());

        return registro;
    }
}
