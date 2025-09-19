package com.e_pass.proj_integrador.model;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Turma {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String nome;
    private String periodo;

    @OneToMany
    @JoinColumn(name = "id_turma")
    private List<Aluno> alunos;

    @ManyToMany
    @JoinTable(
        name = "turma_materia",
        joinColumns = @JoinColumn(name = "turma_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;


    @OneToMany(mappedBy = "turma")
    private List<Aula> aulas;

    @ManyToMany
    @JoinTable(
        name = "turma_professor",
        joinColumns = @JoinColumn(name = "turma_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores;

    // @ManyToMany
    // @JoinTable(
    //     name = "turma_disciplina",
    //     joinColumns = @JoinColumn(name = "turma_id"),
    //     inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    // )
    // private List<Disciplina> disciplinas;

}