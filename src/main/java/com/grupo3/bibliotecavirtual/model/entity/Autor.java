/* package com.grupo3.bibliotecavirtual.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Autor extends BaseEntity {

    @Column(nullable = false, length = 120)
    private String nombre;

    // Relación 1 (Autor) -> N (Libro)
    // mappedBy apunta al nombre del atributo en Libro que referencia a Autor
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    // Timestamps (requerimiento)
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


} */

    package com.grupo3.bibliotecavirtual.model.entity;

import com.grupo3.bibliotecavirtual.model.embeddable.NombreAutor;
import com.grupo3.bibliotecavirtual.model.enums.EstadoAutor;
//import com.grupo3.bibliotecavirtual.model.enums.TipoDocumento;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private NombreAutor nombre;

    /*@Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    private String numeroDocumento;*/

//    @Enumerated(EnumType.STRING)
//    private EstadoAutor estado;

    private String biografia;

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public NombreAutor getNombre() {
        return nombre;
    }

    public void setNombre(NombreAutor nombre) {
        this.nombre = nombre;
    }

//    public TipoDocumento getTipoDocumento() {
//        return tipoDocumento;
//    }
//
//    public void setTipoDocumento(TipoDocumento tipoDocumento) {
//        this.tipoDocumento = tipoDocumento;
//    }
//
//    public String getNumeroDocumento() {
//        return numeroDocumento;
//    }
//
//    public void setNumeroDocumento(String numeroDocumento) {
//        this.numeroDocumento = numeroDocumento;
//    }

//    public EstadoAutor getEstado() {
//        return estado;
//    }
//
//    public void setEstado(EstadoAutor estado) {
//        this.estado = estado;
//    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}