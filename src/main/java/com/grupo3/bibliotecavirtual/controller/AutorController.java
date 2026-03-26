package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.entity.Autor;
import com.grupo3.bibliotecavirtual.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor guardar(@RequestBody Autor autor) {
        return autorService.guardarAutor(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return autorService.listarAutores();
    }

    @GetMapping("/{id}")
    public Autor buscar(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        autorService.eliminarAutor(id);
    }
}