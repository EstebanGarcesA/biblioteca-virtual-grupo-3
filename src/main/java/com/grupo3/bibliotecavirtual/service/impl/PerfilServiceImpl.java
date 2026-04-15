package com.grupo3.bibliotecavirtual.service.impl;

import com.grupo3.bibliotecavirtual.model.entity.Perfil;
import com.grupo3.bibliotecavirtual.repository.PerfilRepository;
import com.grupo3.bibliotecavirtual.service.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository repository;

    public PerfilServiceImpl(PerfilRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Perfil> listar() {
        return repository.findAll();
    }

    @Override
    public Perfil guardar(Perfil perfil) {
        return repository.save(perfil);
    }

    @Override
    public Perfil actualizar(Long id, Perfil perfil) {
        Perfil existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));

        existente.setTipoDocumento(perfil.getTipoDocumento());
        existente.setNumeroDocumento(perfil.getNumeroDocumento());
        existente.setNombre(perfil.getNombre());
        existente.setApellido(perfil.getApellido());
        existente.setDireccion(perfil.getDireccion());
        existente.setTelefono(perfil.getTelefono());

        if (perfil.getUsuario() != null) {
            existente.setUsuario(perfil.getUsuario());
        }
        if (perfil.getPrestamos() != null) {
            existente.setPrestamos(perfil.getPrestamos());
        }

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Perfil no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Perfil buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));
    }
}
