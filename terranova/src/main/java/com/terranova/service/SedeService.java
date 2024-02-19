package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.model.entity.Sede;
import com.terranova.repository.SedeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService implements ICrudService<Sede,Long> {
    private static final String TABLE_NAME="Sedi";

    protected static final Logger logger = LoggerFactory.getLogger(SedeService.class);

    @Autowired protected SedeRepository repository;

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
    public Sede create(Sede sede) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                sede);
        return repository.save(sede);
    }

    @Override
    public Sede update(Long iDSede, Sede sede) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDSede);
        return repository.findById(iDSede).map(SedeTrovato->{
            SedeTrovato.setIDAnagrafica(sede.getIDAnagrafica());
            SedeTrovato.setIndirizzo(sede.getIndirizzo());
            SedeTrovato.setCivico(sede.getCivico());
            SedeTrovato.setCAP(sede.getCAP());
            SedeTrovato.setLocalita(sede.getLocalita());
            SedeTrovato.setProvincia(sede.getProvincia());
            SedeTrovato.setNazione(sede.getNazione());
            return repository.save(SedeTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Contatto non trovato con l'IDAnagrafica fornito")
        );
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
