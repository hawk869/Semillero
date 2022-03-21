package com.danielcepeda.semillerobackend.repository;

import com.danielcepeda.semillerobackend.entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
