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
    public ResponseEntity<List<Talento>> findByNomeAndPreRequisito(@RequestParam(name = "nome", required = false) Optional<String> nome,
                                                                   @RequestParam(name = "preRequisito", required = false) Optional<String> preRequisito) {
        if(nome.isPresent()&&preRequisito.isPresent()){
            return ResponseEntity.ok(service.findByNomeContainingAndPreRequisitoContaining(nome.get(),preRequisito.get()));
        }else if(nome.isPresent()){
            return ResponseEntity.ok(service.findByNomeContaining(nome.get()));
        }else if(preRequisito.isPresent()){
            return ResponseEntity.ok(service.findByPreRequisitoContaining(preRequisito.get()));
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Pelo menos um parametro deve ser informado!");
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
