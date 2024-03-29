package com.terranova.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnagraficaDto {
    private Long iDAnagrafica;
    private String cognome;
    private String nome;
    private String ragSoc;
    private String PIVA;
    private String cFisc;
    private String indirizzo;
    private String civico;
    private String CAP;
    private String localita;
    private String provincia;
    private String nazione;
    private Long numeroTelefonico;
    private String email;
}

