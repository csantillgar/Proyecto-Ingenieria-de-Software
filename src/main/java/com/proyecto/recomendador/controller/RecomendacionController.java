package com.proyecto.recomendador.controller;

import com.proyecto.recomendador.model.Pelicula;
import com.proyecto.recomendador.service.RecomendacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionController {

    private final RecomendacionService service;

    public RecomendacionController(RecomendacionService service) {
        this.service = service;
    }

    @GetMapping("/{usuarioId}")
    public List<Pelicula> getRecomendaciones(@PathVariable Long usuarioId) {
        return service.generarRecomendaciones(usuarioId);
    }
}
