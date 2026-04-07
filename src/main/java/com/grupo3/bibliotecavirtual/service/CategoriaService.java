package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Categoria;


import java.util.List;


public interface CategoriaService {

    List<Categoria> listar();
    Categoria guardar(Categoria categoria);
    Categoria actualizar(Long id, Categoria categoria);
    void eliminar(Long id);
    Categoria buscarPorId(Long id);
}