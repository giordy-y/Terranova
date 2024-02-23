package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.exception.EsecuzioneErrataException;
import com.terranova.exception.ForeignKeyException;
import com.terranova.model.entity.Anagrafica;
import com.terranova.model.entity.Sede;
import com.terranova.repository.AnagraficaRepository;
import com.terranova.repository.SedeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class SedeService implements ICrudService<Sede,Long> {
    private static final String TABLE_NAME="Sedi";

    protected static final Logger logger = LoggerFactory.getLogger(SedeService.class);

    @Autowired protected SedeRepository repository;
    @Autowired protected AnagraficaRepository anagraficaRepository;

    @Override
    public List<Sede> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public Sede findById(Long iDSede) {
        logger.debug(
                "The method findByID has been invoked for the table {}, with parameter ID = {}",
                TABLE_NAME,
                iDSede);
        return  repository.findById(iDSede).orElseThrow(()->new ContattoNotFoundException("nussun Contatto presente con questo IDSede"));
    }

    @Override
    public Sede create(Sede sede) throws ForeignKeyException {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                sede);
        if(!isVerificato(sede)) throw new ForeignKeyException("non esiste nessuna anagrafica che corrisponda a quella data");
        return repository.save(sede);
    }

    @Override
    public Sede update(Long iDSede, @RequestBody Sede sede) throws ForeignKeyException {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDSede);
        if(!isVerificato(sede)) throw new ForeignKeyException("non esiste nessuna anagrafica che corrisponda a quella data");
        return repository.findById(iDSede).map(SedeTrovato->{
            SedeTrovato.setAnagrafica(sede.getAnagrafica());
            SedeTrovato.setDescrizione(sede.getDescrizione());
            SedeTrovato.setIndirizzo(sede.getIndirizzo());
            SedeTrovato.setCivico(sede.getCivico());
            SedeTrovato.setCAP(sede.getCAP());
            SedeTrovato.setLocalita(sede.getLocalita());
            SedeTrovato.setProvincia(sede.getProvincia());
            SedeTrovato.setNazione(sede.getNazione());
            return repository.save(SedeTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Sede non trovata con l'id fornito")
        );
    }

    public boolean isVerificato(@RequestBody Sede sede) throws ForeignKeyException{
        boolean verifica = false;
        List<Anagrafica> listaAnagrafiche = anagraficaRepository.findAll();
        for (Anagrafica anagrafica : listaAnagrafiche) {
            if (anagrafica.equals(sede.getAnagrafica())) {
                verifica = true;
                break;
            }
        }
        return verifica;
    }


    @Override
    public void delete(Long iDSede) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDSede);
        repository.deleteById(iDSede);
    }
}
