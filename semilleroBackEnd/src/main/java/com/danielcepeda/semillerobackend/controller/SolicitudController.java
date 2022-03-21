package com.danielcepeda.semillerobackend.controller;

import com.danielcepeda.semillerobackend.DTO.SolicitudDTO;
import com.danielcepeda.semillerobackend.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService service;

    @GetMapping("/idCliente/{idCliente}")
    public List<SolicitudDTO> listarSolicitudPorIdCliente(@PathVariable Integer idCliente){
        return service.buscarSolicitudPorIdCliente(idCliente);
    }
    @GetMapping("/idTarea/{idTarea}")
    public List<SolicitudDTO> listarSolicitudPorIdTarea (@PathVariable Integer idTarea){
        return service.buscarSolicitudPorIdTarea(idTarea);
    }

    @PostMapping("/{idCliente}/{idTarea}")
    public ResponseEntity<SolicitudDTO> crearSolicitud (@RequestBody SolicitudDTO solicitudDTO, @PathVariable Integer idCliente, @PathVariable Integer idTarea){
        return new ResponseEntity<>(service.crearSolicitud(solicitudDTO,idCliente,idTarea), HttpStatus.CREATED);
    }
}
