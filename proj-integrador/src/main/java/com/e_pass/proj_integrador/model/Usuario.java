package com.e_pass.proj_integrador.model;
import jakarta.persistence.*;


@Entity
public class Usuario {

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @OneToOne
    @JoinColumn(name = "id_professor") 
    private Professor professor;

    // FALTA CRIAR A TABELA RESPONSÁVEL
    @OneToOne
    @JoinColumn(name = "id_responsavel") 
        private Responsavel responsavel;

    
    // CONSTRUTORES
    public Usuario() {
    }
    

    public Usuario(Long id, String email, String senha, TipoUsuario tipo, Professor professor) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.professor = professor;
    }
  




    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }


    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }






}