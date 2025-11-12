package com.epass.epass_be.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotNull
    private long matricula;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @Column(unique = true)
    @NotNull
    private String cpf;

    @NotNull
    private Date dataNascimento;

    private String tipoSanguineo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    
}