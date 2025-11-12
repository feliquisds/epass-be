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
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String titulo;

    private String descricao;

    @NotNull
    private long peso;

    @NotNull
    private Date data;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoAtividade tipo;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Disciplina disciplina;
    
}
