package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.HacedorDTO;
import com.danielcepeda.semillerobackend.entidades.Hacedor;
import com.danielcepeda.semillerobackend.exepciones.ResourceNotFoundExeption;
import com.danielcepeda.semillerobackend.repository.HacedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HacedorImpl implements HacedorService{

    @Autowired
    private HacedorRepository repository;

    @Override
    @Transactional
    public HacedorDTO crearHacedor(HacedorDTO hacedorDTO) {

        Hacedor hacedor = mapearEntidad(hacedorDTO);
        Hacedor nuevoHacedor = repository.save(hacedor);
        HacedorDTO hacedorRespuesta = mapearDTO(nuevoHacedor);

        return hacedorRespuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HacedorDTO> obtenerHacedores() {
        List<Hacedor> hacedors = repository.findAll();
        return hacedors.stream().map(hacedor -> mapearDTO(hacedor))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public HacedorDTO findById(Integer id) {
        Hacedor hacedor = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Hacedor","id",id));
        return mapearDTO(hacedor);
    }

    @Override
    @Transactional
    public HacedorDTO actualizar(HacedorDTO hacedorDTO, Integer id) {
        Hacedor hacedor = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Hacedor","id",id));
        hacedor.setDisponible(hacedorDTO.getDisponible());
        hacedor.setNombreCompleto(hacedorDTO.getNombreCompleto());
        hacedor.setUsuario(hacedorDTO.getUsuario());
        hacedor.setTelefono(hacedorDTO.getTelefono());
        repository.save(hacedor);
        return mapearDTO(hacedor);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Hacedor hacedor = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Hacedor","id",id));
        repository.delete(hacedor);
//        repository.deleteById(id);
    }


    private HacedorDTO mapearDTO (Hacedor hacedor){

        HacedorDTO hacedorDTO = new HacedorDTO();

        hacedorDTO.setIdHacedor(hacedor.getIdHacedor());
        hacedorDTO.setNombreCompleto(hacedor.getNombreCompleto());
        hacedorDTO.setTelefono(hacedor.getTelefono());
        hacedorDTO.setUsuario(hacedor.getUsuario());
        hacedorDTO.setDisponible(hacedor.getDisponible());

        return hacedorDTO;
    }
    private Hacedor mapearEntidad (HacedorDTO dto){

        Hacedor hacedor = new Hacedor();

        hacedor.setIdHacedor(dto.getIdHacedor());
        hacedor.setNombreCompleto(dto.getNombreCompleto());
        hacedor.setTelefono(dto.getTelefono());
        hacedor.setUsuario(dto.getUsuario());
        hacedor.setDisponible(dto.getDisponible());

        return hacedor;
    }

}
