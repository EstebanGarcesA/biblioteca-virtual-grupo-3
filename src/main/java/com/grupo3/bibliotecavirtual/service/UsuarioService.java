package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
    Usuario buscarPorId(Long id);
    Usuario buscarPorEmail(String email);
}
