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
import java.util.Optional;

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

    @GetMapping("/filter")
    public ResponseEntity<List<Talento>> findByNomeAndPreRequisito(@RequestParam(name = "nome", required = false) String nome,
                                                                   @RequestParam(name = "preRequisito", required = false) String preRequisito) {
        if(nome != null || preRequisito != null){
            return ResponseEntity.ok(service.filterTalentoByNomeAndPreRequisito(nome, preRequisito));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Pelo menos um parametro deve ser informado!");
    }

    @PostMapping("/add")
    public ResponseEntity<Talento> save(@RequestBody Talento talento) {
        try {
            talento = service.save(talento);
            return ResponseEntity.ok(talento);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Talento ja cadastrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talento> update(@PathVariable Long id, @RequestBody Talento talento) {
        talento.setId(id);
        talento = service.update(talento);
        return ResponseEntity.ok(talento);
    }
}
