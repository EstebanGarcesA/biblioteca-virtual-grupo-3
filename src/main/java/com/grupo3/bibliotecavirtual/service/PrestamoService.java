package com.grupo3.bibliotecavirtual.service;

import com.grupo3.bibliotecavirtual.model.dto.PrestamoRequest;
import com.grupo3.bibliotecavirtual.model.entity.Prestamo;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> listar();
    Prestamo guardar(Prestamo prestamo);
    Prestamo actualizar(Long id, Prestamo prestamo);
    void eliminar(Long id);
    Prestamo buscarPorId(Long id);
    Prestamo crearPrestamoDesdeGoogle(PrestamoRequest request);
    List<Prestamo> obtenerPorPerfil(Long perfilId);
    Prestamo asignarPerfil(Long prestamoId, Long perfilId);
}
