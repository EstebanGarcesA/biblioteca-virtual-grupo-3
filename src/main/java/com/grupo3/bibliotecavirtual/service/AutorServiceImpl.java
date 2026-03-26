package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.entity.Autor;
import com.grupo3.bibliotecavirtual.model.enums.EstadoAutor;
import com.grupo3.bibliotecavirtual.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        autor.setEstado(EstadoAutor.ACTIVO);
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarAutor(Long id) {
        Autor autor = buscarPorId(id);
        if (autor != null) {
            autor.setEstado(EstadoAutor.INACTIVO);
            autorRepository.save(autor);
        }
    }
}