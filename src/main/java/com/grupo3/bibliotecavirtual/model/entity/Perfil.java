package com.grupo3.bibliotecavirtual.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Entity
@Table(name = "perfil")
@Getter @Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private LocalDate fechaNacimiento;

    private String telefono;


    @OneToOne(mappedBy = "perfil") // Nombre del atributo en Usuario
    private User usuario;
}
