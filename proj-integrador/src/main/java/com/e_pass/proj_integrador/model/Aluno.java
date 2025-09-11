
package com.e_pass.proj_integrador.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
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
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "idAluno"
)
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAluno;

    @Column(unique = true)
    private long matricula;

    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String cpf;

    private Date dataNascimento;

    private String contatoResponsavel;

    private String endereco;

    private String emailResponsavel;

    private String tipoSanguineo;


    @ManyToMany(mappedBy = "alunos")
    private List<Responsavel> responsaveis = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_aluno")
    private List<Documento> documentos;

    // @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    // private List<Frequencia> frequencias;

    public Aluno() {
    }



   
}