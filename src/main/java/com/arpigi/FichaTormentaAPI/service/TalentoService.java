package com.arpigi.FichaTormentaAPI.service;

import com.arpigi.FichaTormentaAPI.entity.Talento;
import com.arpigi.FichaTormentaAPI.exception.TalentoNotFoundException;
import com.arpigi.FichaTormentaAPI.repository.TalentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TalentoService {
    @Autowired
    TalentoRepository repository;

    public List<Talento> findAll() {
        List<Talento> talentos = new ArrayList<>();
        repository.findAll().forEach(talentos::add);
        return talentos;
    }

    public List<Talento> findByNomeContaining(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Talento> findByPreRequisitoContaining(String preRequisito) {
        return repository.findByPreRequisitoContainingIgnoreCase(preRequisito);
    }

    public List<Talento> findByNomeContainingAndPreRequisitoContaining(String nome, String preRequisito) {
        return repository.findByNomeContainingIgnoreCaseAndPreRequisitoContainingIgnoreCase(nome,preRequisito);
    }

    public Talento findById(Long id) throws TalentoNotFoundException {
        Optional<Talento> OpTalento = repository.findById(id);
        if (OpTalento.isPresent()) {
            return OpTalento.get();
        }
        throw new TalentoNotFoundException("TALENTO NÃO ENCONTRADO");
    }

    public Talento save(Talento talento) {
        return repository.save(talento);
    }

    public Talento update(Talento talento) {
        return repository.save(talento);
    }

}
