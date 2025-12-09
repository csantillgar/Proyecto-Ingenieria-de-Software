package com.proyecto.recomendador.repository;
import com.proyecto.recomendador.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
