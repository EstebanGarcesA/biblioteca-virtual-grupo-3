package com.grupo3.bibliotecavirtual.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestamoRequest {

    private String googleId;
    private String nombreLibro;
    private String autores;
    private String thumbnail;
    private String descripcion;

    private Long perfilId;
}