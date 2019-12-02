package com.arpigi.FichaTormentaAPI.controller;

import com.arpigi.FichaTormentaAPI.entity.Talento;
import com.arpigi.FichaTormentaAPI.exception.TalentoNotFoundException;
import com.arpigi.FichaTormentaAPI.service.TalentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/talento")
public class TalentoController {

    @Autowired
    TalentoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Talento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talento> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (TalentoNotFoundException t) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, t.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Talento> save(@RequestBody Talento talento) {
        talento = service.save(talento);
        return ResponseEntity.ok(talento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talento> update(@PathVariable Long id, @RequestBody Talento talento) {
        talento.setId(id);
        talento = service.update(talento);
        return ResponseEntity.ok(talento);
    }
}
