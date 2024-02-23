package com.terranova.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sedi")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDSede;

    @ManyToOne
    @JoinColumn(name = "iDAnagrafica")
    private Anagrafica anagrafica;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "civico")
    private String civico;

    @Column(name = "CAP")
    private String CAP;

    @Column(name = "localita")
    private String localita;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "nazione")
    private String nazione;
}
