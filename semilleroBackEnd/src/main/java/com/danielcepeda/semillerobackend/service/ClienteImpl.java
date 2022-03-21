package com.danielcepeda.semillerobackend.service;

import com.danielcepeda.semillerobackend.DTO.ClienteDTO;
import com.danielcepeda.semillerobackend.entidades.Cliente;
import com.danielcepeda.semillerobackend.exepciones.ResourceNotFoundExeption;
import com.danielcepeda.semillerobackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional
    public ClienteDTO crearCliente(ClienteDTO clienetDTO) {
        Cliente cliente = repository.save(mapearEntidad(clienetDTO));
        return mapearDTO(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> obtenerClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream().map(cliente -> mapearDTO(cliente)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO encontrarClientePorId(Integer id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Cliente","id", id));
        return mapearDTO(cliente);
    }

    @Override
    @Transactional
    public ClienteDTO actualizarCliente(ClienteDTO clienetDTO, Integer id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Cliente","id", id));
        cliente.setNombreCompleto(clienetDTO.getNombreCompleto());
        cliente.setUsuario(clienetDTO.getUsuario());
        cliente.setTelefono(clienetDTO.getTelefono());
        return mapearDTO(repository.save(cliente));
    }

    @Override
    @Transactional
    public void borrarCliente(Integer id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Cliente","id", id));
        repository.delete(cliente);
    }

    private ClienteDTO mapearDTO (Cliente cliente){
        ClienteDTO clienetDTO = new ClienteDTO();
        clienetDTO.setIdCliente(cliente.getIdCliente());
        clienetDTO.setNombreCompleto(cliente.getNombreCompleto());
        clienetDTO.setUsuario(cliente.getUsuario());
        clienetDTO.setTelefono(cliente.getTelefono());
        return clienetDTO;
    }
    private Cliente mapearEntidad (ClienteDTO clienetDTO){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienetDTO.getIdCliente());
        cliente.setNombreCompleto(clienetDTO.getNombreCompleto());
        cliente.setUsuario(clienetDTO.getUsuario());
        cliente.setTelefono(clienetDTO.getTelefono());
        return cliente;
    }

}
