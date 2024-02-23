package com.terranova.model.dto;

import com.terranova.model.entity.Sede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContrattoDto {
    private Long iDRigaContratto;
    private Sede sede;
    private LocalDateTime datatRichiestaServizio;
    private LocalDateTime dataInizioValidita;
    private LocalDateTime dataFineValidita;
    private String descrizioneOfferta;
    private String utility;
    private String statoContratto;
    private String tipoPagamento;
    private Float potenzaImp;
    private Long potDisp;
    private Long energiaAnno;
    private Long gasAnno;
    private Long usoCotturaCibi;
    private Long produzioneAcquaCaldaSanitaria;
    private Long riscaldamentoIndividuale;
    private Long usoCommerciale;
}
