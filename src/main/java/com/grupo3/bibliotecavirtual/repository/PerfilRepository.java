package com.grupo3.bibliotecavirtual.repository;

import com.grupo3.bibliotecavirtual.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
