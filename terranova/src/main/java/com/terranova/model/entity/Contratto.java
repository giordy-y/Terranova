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

    @Column(name = "iDSede")
    private Long iDSede;

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
}

