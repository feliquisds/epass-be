package com.epass.epass_be.model;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private String periodo;

    @NotNull
    private Date dataInicio;

    @NotNull
    private Date dataFinal;

    @ManyToMany
    private List<Aluno> alunos;
    
}