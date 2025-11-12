package com.epass.epass_be.model;

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
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoUsuario destino;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private PrioridadeNotificacao prioridade;

    @ManyToOne
    @JoinColumn
    private Professor professor;

    @ManyToOne
    @JoinColumn
    private Responsavel responsavel;
    
}
