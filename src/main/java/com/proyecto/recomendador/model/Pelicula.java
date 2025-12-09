package com.proyecto.recomendador.model;
import jakarta.persistence.*;


@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private Integer anio;

    @Column(columnDefinition = "TEXT")
    private String sinopsis;

    private Double promedioValoracion = 0.0;

    // JPA
    public Pelicula() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public Double getPromedioValoracion() {
        return promedioValoracion == null ? 0.0 : promedioValoracion;
    }
    public void setPromedioValoracion(Double promedioValoracion) {
        this.promedioValoracion = promedioValoracion == null ? 0.0 : promedioValoracion;
    }
}