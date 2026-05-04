package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.dto.CategoriaRequestDTO;
import com.grupo3.bibliotecavirtual.model.dto.CategoriaResponseDTO;
import com.grupo3.bibliotecavirtual.service.impl.CategoriaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl service;

    public CategoriaController(CategoriaServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaResponseDTO> listar() {
        return service.listarDTO();
    }

    @PostMapping
    public CategoriaResponseDTO guardar(@RequestBody CategoriaRequestDTO dto) {
        return service.guardarDTO(dto);
    }
}