package com.grupo3.bibliotecavirtual.service.impl;

import com.grupo3.bibliotecavirtual.model.entity.Prestamo;
import com.grupo3.bibliotecavirtual.repository.PrestamoRepository;
import com.grupo3.bibliotecavirtual.service.PrestamoService;
import org.springframework.stereotype.Service;
import com.grupo3.bibliotecavirtual.model.dto.PrestamoRequest;
import com.grupo3.bibliotecavirtual.model.entity.Libro;
import com.grupo3.bibliotecavirtual.repository.LibroRepository;
import com.grupo3.bibliotecavirtual.model.enums.EstadoPrestamo;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository repository;

    public PrestamoServiceImpl(PrestamoRepository repository) {
        this.repository = repository;
        
    }

    @Autowired
    private LibroRepository libroRepository;

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

@Override
public Prestamo crearPrestamoDesdeGoogle(PrestamoRequest request) {

    Libro libro = libroRepository.findByGoogleId(request.getGoogleId());

    if (libro == null) {
        libro = new Libro();
        libro.setGoogleId(request.getGoogleId());
        libro.setNombreLibro(request.getNombreLibro());
        libro.setAutoresTexto(request.getAutores());
        libro.setThumbnail(request.getThumbnail());
        libro.setDescripcion(request.getDescripcion());

        libro = libroRepository.save(libro);
    }

    Prestamo prestamo = new Prestamo();
    prestamo.setLibro(libro);
    prestamo.setFechaPrestamo(LocalDate.now());
    prestamo.setEstado(EstadoPrestamo.Prestado);

    return repository.save(prestamo);
}

}
