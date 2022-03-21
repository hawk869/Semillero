package com.danielcepeda.semillerobackend.controller;

import com.danielcepeda.semillerobackend.DTO.HacedorDTO;
import com.danielcepeda.semillerobackend.service.HacedorService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hacedores")
public class HacedorController {

    @Autowired
    private HacedorService service;

    @PostMapping
    public ResponseEntity<HacedorDTO> crearHacedor(@RequestBody HacedorDTO dto){
        return new ResponseEntity<>(service.crearHacedor(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<HacedorDTO> listarHacedores(){
        return service.obtenerHacedores();
    }
    @GetMapping("/{id}")
    public ResponseEntity<HacedorDTO> hacedorPorID (@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity actualizarHacedor (@RequestBody HacedorDTO hacedorDTO, @PathVariable Integer id){
        HacedorDTO hacedorRespuesta = service.actualizar(hacedorDTO, id);
        return new ResponseEntity(hacedorRespuesta, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHacedor(@PathVariable Integer id){
         service.deleteById(id);
         return new ResponseEntity<>("Hacedor eliminado",HttpStatus.OK);
    }
}
