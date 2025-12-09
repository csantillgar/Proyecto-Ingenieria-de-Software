package com.proyecto.recomendador.repository;

import com.proyecto.recomendador.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByUsuarioId(Long usuarioId);
    List<Valoracion> findByPeliculaId(Long peliculaId);
}
