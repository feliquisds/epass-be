package com.epass.epass_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double nota;
    private String status;

    @ManyToOne
    @JoinColumn
    private Atividade atividade;

    @ManyToOne
    @JoinColumn
    private Aluno aluno;
    
}
