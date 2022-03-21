package com.danielcepeda.semillerobackend.controller;

import com.danielcepeda.semillerobackend.DTO.ClienteDTO;
import com.danielcepeda.semillerobackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienetDTO){

        return new ResponseEntity<>(service.crearCliente(clienetDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes(){
        return service.obtenerClientes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> clientePorId (@PathVariable Integer id){
        return ResponseEntity.ok(service.encontrarClientePorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCliente (@RequestBody ClienteDTO clienetDTO, @PathVariable Integer id){
        return new ResponseEntity<>(service.actualizarCliente(clienetDTO,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity borrarCliente(Integer id){
        service.borrarCliente(id);
        return new ResponseEntity("Cliente eliminado",HttpStatus.OK);
    }

}
