package com.danielcepeda.semillerobackend.repository;

import com.danielcepeda.semillerobackend.entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SolicitudRespository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findByCliente_IdCliente(Integer idCliente);
    List<Solicitud> findBySolicitudTareaIdTarea(Integer idTarea);
}
