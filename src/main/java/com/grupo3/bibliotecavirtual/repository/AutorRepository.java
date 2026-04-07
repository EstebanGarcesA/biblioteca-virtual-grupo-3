package com.grupo3.bibliotecavirtual.repository;

import com.grupo3.bibliotecavirtual.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}