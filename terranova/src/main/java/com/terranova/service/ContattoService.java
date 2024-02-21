package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.model.entity.Contatto;
import com.terranova.model.mapper.ContattoMapper;
import com.terranova.repository.ContattoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoService implements ICrudService<Contatto,Long> {
    private static final String TABLE_NAME="Contatti";

    protected static final Logger logger = LoggerFactory.getLogger(ContattoService.class);

    @Autowired protected ContattoRepository repository;

    @Override
    public List<Contatto> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public Contatto findById(Long iDContatto) {
        logger.debug(
                "The method findByIDAnagrafica has been invoked for the table {}, with parameter IDAnagrafica = {}",
                TABLE_NAME,
                iDContatto);
        return  repository.findById(iDContatto).orElseThrow(()->new ContattoNotFoundException("nussun Contatto presente con questo IDAnagrafica"));
    }

    @Override
    public Contatto create(Contatto Contatto) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                Contatto);
        return repository.save(Contatto);
    }

    @Override
    public Contatto update(Long iDContatto, Contatto contatto) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDContatto);
        return repository.findById(iDContatto).map(ContattoTrovato->{
            ContattoTrovato.setIDAnagrafica(contatto.getIDAnagrafica());
            ContattoTrovato.setNome(contatto.getNome());
            ContattoTrovato.setCognome(contatto.getCognome());
            ContattoTrovato.setRagSoc(contatto.getRagSoc());
            ContattoTrovato.setPIVA(contatto.getPIVA());
            ContattoTrovato.setCFisc(contatto.getCFisc());
            ContattoTrovato.setIndirizzo(contatto.getIndirizzo());
            ContattoTrovato.setCivico(contatto.getCivico());
            ContattoTrovato.setCAP(contatto.getCAP());
            ContattoTrovato.setLocalita(contatto.getLocalita());
            ContattoTrovato.setProvincia(contatto.getProvincia());
            ContattoTrovato.setNazione(contatto.getNazione());
            ContattoTrovato.setNumeroTelefonico(contatto.getNumeroTelefonico());
            ContattoTrovato.setEmail(contatto.getEmail());
            return repository.save(ContattoTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Contatto non trovato con l'id fornito")
        );
    }

    @Override
    public void delete(Long iDContatto) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDContatto);
        repository.deleteById(iDContatto);
    }
}
