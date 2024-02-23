package com.terranova.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contratti")
public class Contratto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDRigaContratto;

    @ManyToOne
    @JoinColumn(name = "iDSede")
    private Sede sede;

    @Column(name = "datatRichiestaServizio")
    private LocalDateTime datatRichiestaServizio;

    @Column(name = "dataInizioValidita")
    private LocalDateTime dataInizioValidita;

    @Column(name = "dataFineValidita")
    private LocalDateTime dataFineValidita;

    @Column(name = "descrizioneOfferta")
    private String descrizioneOfferta;

    @Column(name = "utility")
    private String utility;

    @Column(name = "statoContratto")
    private String statoContratto;

    @Column(name = "tipoPagamento")
    private String tipoPagamento;

    @Column(name = "potenzaImp")
    private Float potenzaImp;

    @Column(name = "potDisp")
    private Long potDisp;

    @Column(name = "energiaAnno")
    private Long energiaAnno;

    @Column(name = "gasAnno")
    private Long gasAnno;

    @Column(name = "usoCotturaCibi")
    private Long usoCotturaCibi;

    @Column(name = "produzioneAcquaCaldaSanitaria")
    private Long produzioneAcquaCaldaSanitaria;

    @Column(name = "riscaldamentoIndividuale")
    private Long riscaldamentoIndividuale;

    @Column(name = "usoCommerciale")
    private Long usoCommerciale;

}

