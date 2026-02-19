package com.grupo3.bibliotecavirtual.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    @OneToOne(cascade = CascadeType.ALL) // Si guardo usuario, se guarda perfil
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    private Perfil perfil;
}
