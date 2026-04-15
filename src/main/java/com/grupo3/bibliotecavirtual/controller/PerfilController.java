package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.entity.Perfil;
import com.grupo3.bibliotecavirtual.service.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Perfil> guardar(@RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(perfil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> actualizar(@PathVariable Long id, @RequestBody Perfil perfil) {
        return ResponseEntity.ok(service.actualizar(id, perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
