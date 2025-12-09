package com.proyecto.recomendador.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "valoraciones")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    private Integer puntuacion; // 1..5

    @Column(columnDefinition = "TEXT")
    private String comentario;

    private LocalDateTime creado = LocalDateTime.now();

    public Valoracion() {}

    public Valoracion(Long id, Usuario usuario, Pelicula pelicula, Integer puntuacion, String comentario, LocalDateTime creado) {
        this.id = id;
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.creado = creado == null ? LocalDateTime.now() : creado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public Integer getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Integer puntuacion) { this.puntuacion = puntuacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getCreado() { return creado; }
    public void setCreado(LocalDateTime creado) { this.creado = creado; }
}
