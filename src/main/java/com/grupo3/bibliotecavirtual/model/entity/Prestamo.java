package com.grupo3.bibliotecavirtual.model.entity;

import com.grupo3.bibliotecavirtual.model.enums.EstadoPrestamo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prestamo")
@Getter
@Setter

public class Prestamo extends BaseEntity {
    


    @ManyToOne
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties({"autor", "categoria", "estado"})
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    @JsonIgnoreProperties({"usuario", "prestamos"})
    private Perfil perfil;

    private java.time.LocalDate fechaPrestamo;
    
    private java.time.LocalDate fechaDevolucion;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

}
