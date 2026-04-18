package com.grupo3.bibliotecavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.bibliotecavirtual.model.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
     Libro findByGoogleId(String googleId);
}