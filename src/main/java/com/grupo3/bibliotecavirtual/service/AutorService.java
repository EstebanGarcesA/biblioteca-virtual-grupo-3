package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Autor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AutorService {

    Autor guardarAutor(Autor autor);

    List<Autor> listarAutores();

    Autor buscarPorId(Long id);

    void eliminarAutor(Long id);
}
