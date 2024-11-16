package com.juegodemesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juegodemesa.model.Juego;


public interface JuegoRepository extends JpaRepository<Juego, Long> {
}