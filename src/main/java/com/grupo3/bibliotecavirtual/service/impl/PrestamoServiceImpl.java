package com.grupo3.bibliotecavirtual.service.impl;

import com.grupo3.bibliotecavirtual.model.entity.Prestamo;
import com.grupo3.bibliotecavirtual.repository.PrestamoRepository;
import com.grupo3.bibliotecavirtual.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository repository;

    public PrestamoServiceImpl(PrestamoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prestamo> listar() {
        return repository.findAll();
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        return repository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Long id, Prestamo prestamo) {
        Prestamo existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado con id: " + id));

        if (prestamo.getLibro() != null) {
            existente.setLibro(prestamo.getLibro());
        }
        if (prestamo.getPerfil() != null) {
            existente.setPerfil(prestamo.getPerfil());
        }
        existente.setFechaPrestamo(prestamo.getFechaPrestamo());
        existente.setEstado(prestamo.getEstado());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Prestamo no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Prestamo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado con id: " + id));
    }
}
