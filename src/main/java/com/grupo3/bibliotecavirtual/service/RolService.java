package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Rol;

import java.util.List;

public interface RolService {

    List<Rol> listar();
    Rol guardar(Rol rol);
    Rol actualizar(Long id, Rol rol);
    void eliminar(Long id);
    Rol buscarPorId(Long id);
}
