package com.arpigi.FichaTormentaAPI.repository;

import com.arpigi.FichaTormentaAPI.entity.Talento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TalentoRepositoryCustomImpl implements TalentoRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<Talento> filterByNomeAndPreRequisito(String nome, String preRequisito) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Talento> cq = cb.createQuery(Talento.class);
        Root<Talento> root = cq.from(Talento.class);
        List<Predicate> predicates = new ArrayList<>();

        if(nome != null && !nome.isEmpty()){
            predicates.add( cb.like(cb.upper(root.get("nome")),"%"+nome.toUpperCase()+"%"));
        }

        if(preRequisito != null && !preRequisito.isEmpty()){
            predicates.add(cb.like(cb.upper(root.get("preRequisito")),"%"+preRequisito.toUpperCase()+"%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

}
