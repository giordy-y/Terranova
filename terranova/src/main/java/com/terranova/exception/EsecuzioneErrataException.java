package com.terranova.exception;

// ECCEZIONE CUSTOM PER EVENTUALI LANCI DI ECCEZIONI
public class EsecuzioneErrataException extends Exception {

    public EsecuzioneErrataException(String err) {
        System.out.println(err);
    }
}