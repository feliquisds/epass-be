package com.epass.epass_be.model;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String endereco;
    private String formacao;
    private String turno;
    private Date dataNascimento;
    private String status;

    @OneToMany
    private List<Disciplina> disciplinas;

}