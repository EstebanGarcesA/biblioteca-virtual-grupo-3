package com.grupo3.bibliotecavirtual.model.entity;

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

    // Muchos libros a un autor
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    // Muchos libros a una categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Muchos libros a un estado
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

}
