package com.grupo3.bibliotecavirtual.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "libro")
@Getter
@Setter
public class Libro extends BaseEntity {

    private String nombreLibro;

    private int cantidadPaginas;

    @Column(unique = true)
    private String googleId;

    private String thumbnail;

    @Column(length = 2000)
    private String descripcion;

    private String autoresTexto;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnoreProperties("libros") // el nombre del campo en Autor que apunta a List<Libro>
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("libros")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    @JsonIgnoreProperties("libros")
    private Estado estado;

}
