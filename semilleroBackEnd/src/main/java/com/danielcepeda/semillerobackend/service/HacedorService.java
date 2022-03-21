package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.HacedorDTO;

import java.util.List;

public interface HacedorService {

    public HacedorDTO crearHacedor(HacedorDTO hacedorDTO);
    public List<HacedorDTO> obtenerHacedores();
    public HacedorDTO findById (Integer id);
    public HacedorDTO actualizar (HacedorDTO hacedorDTO, Integer id);
    public void deleteById (Integer id);
}
