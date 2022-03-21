package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.ClienteDTO;

import java.util.List;

public interface ClienteService {

    public ClienteDTO crearCliente (ClienteDTO clienetDTO);
    public List<ClienteDTO> obtenerClientes();
    public ClienteDTO encontrarClientePorId (Integer id);
    public ClienteDTO actualizarCliente (ClienteDTO clienetDTO, Integer id);
    public void borrarCliente (Integer id);
}
