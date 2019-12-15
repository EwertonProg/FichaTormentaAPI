package com.arpigi.FichaTormentaAPI.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoPreRequisito {
    TALENTO("Talento"),
    CLASSE("Classe"),
    HABILIDADE("Habilidade"),
    RACA("Raça"),
    PERICIA("Pericia");

    private String descricao;

    TipoPreRequisito(String descricao) {
        this.descricao = descricao;
    }

    public static Map<String, String> getHash() {
        Map<String, String> map = new HashMap<>();
        for (TipoPreRequisito t : TipoPreRequisito.values()) {
            map.put(t.toString(), t.descricao);
        }
        return map;
    }

    public String getDescricao() {
        return descricao;
    }
}
