package com.grupo3.bibliotecavirtual.model.entity;

import com.grupo3.bibliotecavirtual.model.enums.EstadoPrestamo;
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
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    private java.time.LocalDate fechaPrestamo;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

}
