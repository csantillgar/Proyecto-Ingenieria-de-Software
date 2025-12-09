package com.proyecto.recomendador.service;
import com.proyecto.recomendador.model.Pelicula;
import com.proyecto.recomendador.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

// creamos este MVP para que se pueda devolver las peliculas mas valoradas primero a traves de promedioValoracion
@Service
public class RecomendacionService {

    private final PeliculaRepository peliculaRepository;

    public RecomendacionService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> generarRecomendaciones(Long usuarioId) {
        return peliculaRepository.findAll().stream()
                .sorted(Comparator.comparingDouble((Pelicula p) -> p.getPromedioValoracion() == null ? 0.0 : p.getPromedioValoracion()).reversed())
                .toList();
    }
}