package com.juegodemesa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.juegodemesa.model.Juego;
import com.juegodemesa.service.JuegoService;


@RestController
@RequestMapping ("/api/juego")
public class Juegocontroller {

    @Autowired
    private JuegoService juegoService;

    public List<Juego> listaJuego() {
        return juegoService.listarJuego(); 
    }

    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoService.guardarJuego(juego);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Juego> obtenerJuego(@PathVariable Long id) {
        Optional<Juego> juego = juegoService.obtenerJuego(id);
        return juego.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarJuego (@PathVariable Long id) {
        juegoService.eliminarJuego(id);

    }

}
