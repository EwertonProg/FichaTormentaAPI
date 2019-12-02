package com.arpigi.FichaTormentaAPI.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
public class Origem {
    @Id
    @SequenceGenerator(name = "seq_origem_id", sequenceName = "seq_origem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_origem_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false, length = 60)
    private String nome;

    private String descricao;

}
