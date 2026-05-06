package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Perfil;

import java.util.List;

public interface PerfilService {

    List<Perfil> listar();
    Perfil guardar(Perfil perfil);
    Perfil actualizar(Long id, Perfil perfil);
    void eliminar(Long id);
    Perfil buscarPorId(Long id);
}