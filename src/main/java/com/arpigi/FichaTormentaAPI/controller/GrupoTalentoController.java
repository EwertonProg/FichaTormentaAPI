package com.arpigi.FichaTormentaAPI.controller;

import com.arpigi.FichaTormentaAPI.entity.GrupoTalento;
import com.arpigi.FichaTormentaAPI.exception.GrupoTalentoNotFoundException;
import com.arpigi.FichaTormentaAPI.service.GrupoTalentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/grupoTalento")
public class GrupoTalentoController {

    @Autowired
    GrupoTalentoService service;

    @GetMapping("/all")
    public List<GrupoTalento> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GrupoTalento findById(@PathVariable Long id) {
        try {
            return service.findById(id);
        } catch (GrupoTalentoNotFoundException t) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, t.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<GrupoTalento> save(@RequestBody GrupoTalento grupoTalento) {
        grupoTalento = service.save(grupoTalento);
        return ResponseEntity.ok(grupoTalento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoTalento> update(@PathVariable Long id, @RequestBody GrupoTalento grupoTalento) {
        grupoTalento.setId(id);
        grupoTalento = service.update(grupoTalento);
        return ResponseEntity.ok(grupoTalento);
    }
}
