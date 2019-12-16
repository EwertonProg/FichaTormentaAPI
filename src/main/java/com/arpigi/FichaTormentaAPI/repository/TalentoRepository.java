package com.arpigi.FichaTormentaAPI.repository;

import com.arpigi.FichaTormentaAPI.entity.Talento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TalentoRepository extends CrudRepository<Talento, Long> {
    List<Talento> findByNomeContainingIgnoreCase(String nome);
    List<Talento> findByPreRequisitoContainingIgnoreCase(String preRequisito);
    List<Talento> findByNomeContainingIgnoreCaseAndPreRequisitoContainingIgnoreCase(String nome, String preRequisito);
}
