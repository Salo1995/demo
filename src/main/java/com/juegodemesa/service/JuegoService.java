package com.juegodemesa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegodemesa.model.Juego;
import com.juegodemesa.repository.JuegoRepository;

@Service
public class JuegoService  {

    @Autowired
    private JuegoRepository juegoRepository;

    public List<Juego> listarJuego() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> obtenerJuego(Long id) {
        return juegoRepository.findById(id);
    }

    public Juego guardarJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    public void eliminarJuego(Long id) {
        juegoRepository.deleteById(id);
    }
}