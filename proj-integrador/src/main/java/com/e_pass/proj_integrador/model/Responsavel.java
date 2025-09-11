package com.e_pass.proj_integrador.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
@Entity
@Getter
@Setter
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;

    @ManyToMany
    @JoinTable(
        name = "relacao_responsavel_aluno", // tabela intermediária
        joinColumns = @JoinColumn(name = "responsavel_id", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "idAluno")
    )
    private List<Aluno> alunos = new ArrayList<>();



    
    

}
