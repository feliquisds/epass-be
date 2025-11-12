package com.epass.epass_be.model;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
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
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String titulo;

    private String descricao;

    @NotNull
    private Date dataInicio;

    private Date dataFinal;

    @NotNull
    private Time horarioInicio;

    private Time horarioFinal;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Agenda agenda;
    
}
