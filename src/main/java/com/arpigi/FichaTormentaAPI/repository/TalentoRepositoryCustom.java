package com.arpigi.FichaTormentaAPI.repository;

import com.arpigi.FichaTormentaAPI.entity.Talento;

import java.util.List;

public interface TalentoRepositoryCustom{
    List<Talento> filterByNomeAndPreRequisito(String nome, String preRequisito);
}
