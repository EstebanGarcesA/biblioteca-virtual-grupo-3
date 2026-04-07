package com.grupo3.bibliotecavirtual.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter
@Setter

public class Perfil extends BaseEntity {

  private String tipoDocumento;
  private String numeroDocumento;
  private String nombre;
  private String apellido;
  private String direccion;
  private String telefono;

    @OneToOne(mappedBy = "perfil")
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "perfil")
    private List<Prestamo> prestamos;

}
