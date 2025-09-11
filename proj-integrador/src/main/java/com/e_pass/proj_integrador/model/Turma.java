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

    @OneToMany
    @JoinColumn(name = "id_turma")
    private List<Materia> materias;

    // @ManyToMany
    // @JoinTable(
    //     name = "relacao_turma_materia", // tabela intermediária
    //     joinColumns = @JoinColumn(name = "turma_id", referencedColumnName = "ID"),
    //     inverseJoinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "ID")
    // )
    // private List<Materia> materias = new ArrayList<>();

}