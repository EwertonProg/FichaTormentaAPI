package com.arpigi.FichaTormentaAPI.controller;

import com.arpigi.FichaTormentaAPI.entity.Origem;
import com.arpigi.FichaTormentaAPI.exception.OrigemNotFoundExceprion;
import com.arpigi.FichaTormentaAPI.service.OrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/origem")
public class OrigemController {
    @Autowired
    OrigemService service;

    @GetMapping("/all")
    public ResponseEntity<List<Origem>> findAll() {
        List<Origem> origens = service.findAll();
        return ResponseEntity.ok(origens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Origem> findById(@PathVariable Long id) {
        try {
            Origem origem = service.findById(id);
            return ResponseEntity.ok(origem);
        } catch (OrigemNotFoundExceprion o) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, o.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<Origem> save(@RequestBody Origem origem){
        origem = service.save(origem);
        return ResponseEntity.ok(origem);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Origem> save(@PathVariable Long id, @RequestBody Origem origem){
        origem.setId(id);
        origem = service.save(origem);
        return ResponseEntity.ok(origem);
    }


}
