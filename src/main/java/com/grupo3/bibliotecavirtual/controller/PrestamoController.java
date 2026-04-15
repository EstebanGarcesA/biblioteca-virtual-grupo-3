package com.grupo3.bibliotecavirtual.controller;

import com.grupo3.bibliotecavirtual.model.entity.Prestamo;
import com.grupo3.bibliotecavirtual.service.PrestamoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(@RequestBody Prestamo prestamo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(service.actualizar(id, prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
