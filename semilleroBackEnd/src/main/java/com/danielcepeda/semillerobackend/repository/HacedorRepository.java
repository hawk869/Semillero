package com.danielcepeda.semillerobackend.repository;

import com.danielcepeda.semillerobackend.entidades.Hacedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HacedorRepository extends JpaRepository<Hacedor, Integer> {
}
