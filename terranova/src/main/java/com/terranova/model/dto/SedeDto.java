package com.terranova.model.dto;

import com.terranova.model.entity.Anagrafica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SedeDto {
    private Long iDSede;
    private Anagrafica anagrafica;
    private String descrizione;
    private String indirizzo;
    private String civico;
    private String CAP;
    private String localita;
    private String provincia;
    private String nazione;
}
