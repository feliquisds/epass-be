package com.e_pass.proj_integrador.model;


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
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private Boolean presenca;

    @ManyToOne
    @JoinColumn(name = "id_frequencia")
    private Aluno aluno;



   
}