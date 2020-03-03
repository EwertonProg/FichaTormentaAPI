package com.arpigi.FichaTormentaAPI.resolvers;

import com.arpigi.FichaTormentaAPI.entity.Talento;
import com.arpigi.FichaTormentaAPI.exception.TalentoNotFoundException;
import com.arpigi.FichaTormentaAPI.service.TalentoService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TalentoQueryResolver implements GraphQLQueryResolver {
    @Autowired
    TalentoService talentoService;

    public List<Talento> getTalentos(){
        return talentoService.findAll();
    }

    public Talento getTalento(Long id){
        try{
            return talentoService.findById(id);
        }catch(TalentoNotFoundException t){
            return null;
        }
    }
}
