package com.arpigi.FichaTormentaAPI.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Table(name = "GRUPO_TALENTO")
@Entity
public class GrupoTalento {
    @Id
    @SequenceGenerator(name = "seq_grupo_talento_id", sequenceName = "seq_grupo_talento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_grupo_talento_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    private String descricao;
}
