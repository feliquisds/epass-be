package com.epass.epass_be.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    private Date dataPedido;

    @NotNull
    private Date dataEmissao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private DocumentoStatus status;

    private String pathDocumento;

    @ManyToOne
    @JoinColumn
    private Aluno aluno;

    @ManyToOne
    @JoinColumn
    private Professor professor;
    
}