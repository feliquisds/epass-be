package com.epass.epass_be.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    public String nome;
    public String descricao;
    public int cargaHoraria;

    @ManyToMany(mappedBy = "materias")
    private List<Turma> turmas;

    
    @OneToMany
    @JoinColumn(name = "id_materia")
    private List<Atividade> atividades;


    // @ManyToMany(mappedBy = "materias")
    // private List<Turma> turmas = new ArrayList<>();

    // @OneToMany
    // @JoinColumn(name = "id_materia")
    // private List<Materia> materias;



}