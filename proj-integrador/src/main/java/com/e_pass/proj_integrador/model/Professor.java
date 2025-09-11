package com.e_pass.proj_integrador.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String cpf;

    private String nome;
    private String sobrenome;

    private String email;
    private String telefone;

    private Date dataNascimento;

    private String disciplina;


    @OneToMany
    @JoinColumn(name = "id_professor")
    private List<Materia> materias;

   
}