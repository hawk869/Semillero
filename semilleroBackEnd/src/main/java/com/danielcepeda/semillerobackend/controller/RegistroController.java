package com.danielcepeda.semillerobackend.controller;

import com.danielcepeda.semillerobackend.DTO.RegistroDTO;
import com.danielcepeda.semillerobackend.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {

    @Autowired
    private RegistroService service;

    @GetMapping
    public List<RegistroDTO> registroDTOList(){
        return service.obtenerRegistros();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistroDTO> buscarRegistroPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarRegistroPorId(id));
    }
    @GetMapping("/idTarea/{idTarea}")
    public List<RegistroDTO> listarRegistrosPorIdTarea (@PathVariable Integer idTarea){
        return service.buscarRegistroPorTareaId(idTarea);
    }
    @GetMapping("/idHacedor/{idHacedor}")
    public List<RegistroDTO> listarRegistroPorIdHacedor (@PathVariable Integer idHacedor){
        return service.buscarRegistroPorHacedorID(idHacedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarRegistro (@PathVariable Integer id){
        service.borrarRegistro(id);
        return new ResponseEntity<>("Registro eliminado",HttpStatus.OK);
    }

    @PostMapping("/{idHacedor}/{idTarea}")
    private ResponseEntity<RegistroDTO> crearRegistro (@RequestBody RegistroDTO registroDTO, @PathVariable Integer idHacedor, @PathVariable Integer idTarea){
        return new ResponseEntity<>(service.crearRegistro(registroDTO,idHacedor,idTarea),HttpStatus.CREATED);
    }
    @PutMapping("/{id}/{idTarea}")
    private ResponseEntity<RegistroDTO> actualizarRegistro (@RequestBody RegistroDTO registroDTO, @PathVariable Integer id, @PathVariable Integer idTarea){
        return new ResponseEntity(service.actualizarRegistro(registroDTO,id,idTarea),HttpStatus.OK);
    }
    
}
