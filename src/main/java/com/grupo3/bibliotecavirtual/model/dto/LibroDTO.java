package com.grupo3.bibliotecavirtual.model.dto;

import lombok.Getter;
import lombok.Setter;
import com.grupo3.bibliotecavirtual.model.entity.Autor;
import com.grupo3.bibliotecavirtual.model.entity.Categoria;
import com.grupo3.bibliotecavirtual.model.entity.Estado;

import java.time.LocalDate;

@Getter
@Setter
public class LibroDTO {

    private Long id;
    private String nombreLibro;
    private int cantidadPaginas;
    private String googleId;
    private String thumbnail;
    private String descripcion;
    private String autoresTexto;

    // Objetos completos en lugar de IDs
    private Autor autor;
    private Categoria categoria;
    private Estado estado;

    // Fechas de auditoría
    private LocalDate fechaRegistro;
    private LocalDate fechaModificacion;
}