package com.arpigi.FichaTormentaAPI.service;

import com.arpigi.FichaTormentaAPI.entity.GrupoTalento;
import com.arpigi.FichaTormentaAPI.exception.GrupoTalentoNotFoundException;
import com.arpigi.FichaTormentaAPI.repository.GrupoTalentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoTalentoService {
    @Autowired
    GrupoTalentoRepository repository;

    public List<GrupoTalento> findAll() {
        List<GrupoTalento> gruposTalento = new ArrayList<>();
        repository.findAll().forEach(gruposTalento::add);
        return gruposTalento;
    }

    public GrupoTalento save(GrupoTalento grupoTalento) {
        return repository.save(grupoTalento);
    }

    public GrupoTalento findById(Long id) throws GrupoTalentoNotFoundException {
        Optional<GrupoTalento> talento = repository.findById(id);
        if (talento.isPresent()) {
            return talento.get();
        }
        throw new GrupoTalentoNotFoundException("GRUPO DE TALENTO NÃO ENCONTRADO");
    }

    public GrupoTalento update(GrupoTalento grupoTalento) {
        return repository.save(grupoTalento);
    }
}
