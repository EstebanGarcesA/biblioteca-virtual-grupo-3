package com.grupo3.bibliotecavirtual.repository;

import com.grupo3.bibliotecavirtual.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}