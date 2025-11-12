package com.epass.epass_be.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private long matricula;

    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String cpf;

    private Date dataNascimento;
    private String endereco;
    private String tipoSanguineo;
    private String status;
    
}