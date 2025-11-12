package com.epass.epass_be.model;

import java.sql.Date;
import java.sql.Time;
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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Date dataCompra;

    @NotNull
    private Time horaCompra;

    @NotNull
    private double valorCompra;

    @NotNull
    private String descricaoCompra;

    @Enumerated(EnumType.STRING)
    @NotNull
    private CompraStatus status;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Carteira carteira;
    
}
