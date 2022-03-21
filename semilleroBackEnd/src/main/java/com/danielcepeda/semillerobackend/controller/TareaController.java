package com.danielcepeda.semillerobackend.controller;

import com.danielcepeda.semillerobackend.DTO.TareaDTO;
import com.danielcepeda.semillerobackend.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {

    @Autowired
    private TareaService service;

    @GetMapping
    public List<TareaDTO> obtenerTareas (){
        return service.obtenerTareas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> obtenerTareaPorID(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarTareaPorId(id));
    }

    @PostMapping
    public ResponseEntity<TareaDTO> crearTarea (@RequestBody TareaDTO tareaDTO){
        return new ResponseEntity<>(service.crearTarea(tareaDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> actualizarTarea (@RequestBody TareaDTO tareaDTO,@PathVariable Integer id){
        return new ResponseEntity(service.actualizarTarea(tareaDTO,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTarea (@PathVariable Integer id){
        service.borrarTarea(id);
        return new ResponseEntity<>("Tarea eliminada",HttpStatus.OK);
    }
}
