package com.e_pass.proj_integrador.model;

import java.util.List;
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
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    public String nome;
    public String descricao;
    public int cargaHoraria;

    @OneToMany
    @JoinColumn(name = "id_materia")
    private List<Aula> aulas;


    // @ManyToMany(mappedBy = "materias")
    // private List<Turma> turmas = new ArrayList<>();

    // @OneToMany
    // @JoinColumn(name = "id_materia")
    // private List<Materia> materias;



}