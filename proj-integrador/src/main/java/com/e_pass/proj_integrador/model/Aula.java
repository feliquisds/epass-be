package com.e_pass.proj_integrador.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "idAula"
)
@Entity
@Getter
@Setter
public class Aula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAula;

    private Date data;

    private String titulo;

    private String descricao;

    // @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    // private List<Frequencia> frequencias;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "aula")
    private List<Atividade> atividades;

    @OneToMany
    @JoinColumn(name = "id_aula")
    private List<Frequencia> frequencias;



}
