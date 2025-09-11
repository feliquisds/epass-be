package com.e_pass.proj_integrador.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    public String nome;
    public String descricao;
    public int cargaHoraria;


    @ManyToMany(mappedBy = "materias")
    private List<Turma> turmas = new ArrayList<>();



}