package com.grupo3.bibliotecavirtual.model.dto;

import lombok.Getter;
import lombok.Setter;
import com.grupo3.bibliotecavirtual.model.entity.Perfil;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
public class PrestamoRequest {

    // En lugar de campos individuales, usar objeto Libro completo
    private LibroDTO libro;

    private Long perfilId;

    // Fecha de devolución seleccionada por el usuario
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaDevolucion;

    // También podemos incluir el perfil completo si es necesario
    // private Perfil perfil;
}