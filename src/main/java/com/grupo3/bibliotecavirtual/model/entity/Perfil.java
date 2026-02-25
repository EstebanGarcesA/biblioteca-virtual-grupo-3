package com.grupo3.bibliotecavirtual.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "perfil")
@Getter
@Setter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String bio;

    private LocalDate fechaNacimiento;

    @Column(length = 20)
    private String telefono;

    // Relación bidireccional (lado inverso)
    @OneToOne(mappedBy = "perfil")
    private User usuario;

    // Constructor vacío obligatorio para JPA
    public Perfil() {
    }

    public Perfil(String bio, LocalDate fechaNacimiento, String telefono) {
        this.bio = bio;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
}