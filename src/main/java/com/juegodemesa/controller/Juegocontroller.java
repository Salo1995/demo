package com.juegodemesa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegodemesa.model.Juego;
import com.juegodemesa.service.JuegoService;

@RestController
@RequestMapping("/api/juego")
public class Juegocontroller {

    @Autowired
    private JuegoService juegoService;

    // Método para listar todos los juegos
    @GetMapping
    public List<Juego> listaJuego() {
        return juegoService.listarJuego(); 
    }

    // Método para crear un nuevo juego
    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoService.guardarJuego(juego);
    }

    // Método para obtener un juego por ID
    @GetMapping("/{id}")
    public ResponseEntity<Juego> obtenerJuego(@PathVariable Long id) {
        Optional<Juego> juego = juegoService.obtenerJuego(id);
        return juego.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para eliminar un juego por ID
    @DeleteMapping("/{id}")
    public void eliminarJuego(@PathVariable Long id) {
        juegoService.eliminarJuego(id);
    }
}
