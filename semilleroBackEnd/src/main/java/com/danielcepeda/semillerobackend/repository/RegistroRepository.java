package com.danielcepeda.semillerobackend.repository;

import com.danielcepeda.semillerobackend.entidades.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    List<Registro> findByTareaIdTarea (Integer idTarea);
    List<Registro> findByHacedor_IdHacedor (Integer idHacedor);
}
