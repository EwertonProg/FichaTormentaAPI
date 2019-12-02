package com.arpigi.FichaTormentaAPI.service;

import com.arpigi.FichaTormentaAPI.entity.Origem;
import com.arpigi.FichaTormentaAPI.exception.OrigemNotFoundExceprion;
import com.arpigi.FichaTormentaAPI.repository.OrigemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrigemService {
    @Autowired
    OrigemRepository repository;

    public List<Origem> findAll() {
        List<Origem> retornoOrigens = new ArrayList<>();
        repository.findAll().forEach(retornoOrigens::add);
        return retornoOrigens;
    }

    public Origem findById(Long id) throws OrigemNotFoundExceprion {
        Optional<Origem> retornoOrigem = repository.findById(id);
        if (retornoOrigem.isPresent()) {
            return retornoOrigem.get();
        }
         throw new OrigemNotFoundExceprion("ORIGEM NÃO ENCONTRADA");
    }

    public Origem save(Origem origem) {
        return repository.save(origem);
    }

    public Origem update(Origem origem) {
        return repository.save(origem);
    }
}
