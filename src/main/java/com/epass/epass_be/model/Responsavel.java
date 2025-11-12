package com.epass.epass_be.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
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
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Column(unique = true)
    @NotNull
    private String cpf;

    @NotNull
    private String email;

    @NotNull
    private String telefone;

    @NotNull
    private String endereco;

    @NotNull
    private Date dataNascimento;

    @ManyToMany
    private List<Aluno> alunos;
    
}
