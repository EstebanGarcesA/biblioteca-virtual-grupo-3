package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.entity.Libro;
import com.grupo3.bibliotecavirtual.model.dto.LibroDTO;
import com.grupo3.bibliotecavirtual.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listar() {
        return libroService.listarLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }

    @PostMapping
    public Libro guardar(@RequestBody LibroDTO libroDTO) {
        // Convertir DTO a entidad
        Libro libro = convertirDTOaEntidad(libroDTO);
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        libroDTO.setId(id);
        Libro libro = convertirDTOaEntidad(libroDTO);
        return libroService.guardarLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

    private Libro convertirDTOaEntidad(LibroDTO dto) {
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setNombreLibro(dto.getNombreLibro());
        libro.setCantidadPaginas(dto.getCantidadPaginas());
        libro.setGoogleId(dto.getGoogleId());
        libro.setThumbnail(dto.getThumbnail());
        libro.setDescripcion(dto.getDescripcion());
        libro.setAutoresTexto(dto.getAutoresTexto());

        // Asignar objetos completos
        libro.setAutor(dto.getAutor());
        libro.setCategoria(dto.getCategoria());
        libro.setEstado(dto.getEstado());

        return libro;
    }
}