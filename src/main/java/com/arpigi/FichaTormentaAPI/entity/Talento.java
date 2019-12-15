package com.arpigi.FichaTormentaAPI.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Table(uniqueConstraints = @UniqueConstraint(name = "unq_nome_origem", columnNames = {"nome", "id_origem"}))
@Entity
public class Talento {

    @Id
    @SequenceGenerator(name = "sq_talento_id", sequenceName = "sq_talento_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_talento_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = " TEXT ")
    private String descricao;

    @Column(columnDefinition = " TEXT ", name = "beneficio_formadato")
    private String beneficioFormatado;

    @Column(nullable = false, columnDefinition = " TEXT ")
    private String beneficio;

    @Column(columnDefinition = " TEXT ", name = "especial_formatado")
    private String especialFormatado;

    @Column(columnDefinition = " TEXT ")
    private String especial;

    @ManyToOne
    @JoinColumn(name = "id_grupo_talento", nullable = false)
    private GrupoTalento grupoTalento;

    @ManyToOne
    @JoinColumn(name = "id_origem", nullable = false)
    private Origem origem;

    @Column(columnDefinition = " TEXT ", name = "pre_requisito_formatado")
    private String preRequisitoFormatada;

    @Column(name = "pre_requisito", columnDefinition = " TEXT ")
    private String preRequisito;
}
