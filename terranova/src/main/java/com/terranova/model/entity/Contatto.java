package com.terranova.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contatti")
public class Contatto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDContatto;
    @ManyToOne
    @JoinColumn(name = "iDAnagrafica")
    private Anagrafica anagrafica;
    @Column(name = "nome")
    private String nome;
    @Column(name = "coognome")
    private String cognome;
    @Column(name ="ragSoc")
    private String ragSoc;
    @Column(name = "PIVA")
    private String PIVA;
    @Column(name = "cFisc")
    private String cFisc;
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
    @Column(name = "numeroTelefonico")
    private Long numeroTelefonico;
    @Column(name = "email")
    private String email;

}
