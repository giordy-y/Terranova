package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.model.entity.Contratto;
import com.terranova.model.mapper.ContattoMapper;
import com.terranova.repository.ContattoRepository;
import com.terranova.repository.ContrattoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContrattoService implements ICrudService<Contratto,Long>{

    private static final String TABLE_NAME="Contratti";

    protected static final Logger logger = LoggerFactory.getLogger(ContrattoService.class);


    @Autowired
    protected ContrattoRepository repository;
    @Override
    public List<Contratto> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public Contratto findById(Long iDContratto) {
        logger.debug(
                "The method findByIDAnagrafica has been invoked for the table {}, with parameter id = {}",
                TABLE_NAME,
                iDContratto);
        return  repository.findById(iDContratto).orElseThrow(()->new ContattoNotFoundException("nussun Contatto presente con questo id"));
    }

    @Override
    public Contratto create(Contratto Contatto) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                Contatto);
        return repository.save(Contatto);
    }

    @Override
    public Contratto update(Long iDConrtatto, Contratto contratto) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDConrtatto);
        return repository.findById(iDConrtatto).map(ContrattoTrovato->{
            ContrattoTrovato.setDatatRichiestaServizio(contratto.getDatatRichiestaServizio());
            ContrattoTrovato.setDataInizioValidita(contratto.getDataInizioValidita());
            ContrattoTrovato.setDataFineValidita(contratto.getDataFineValidita());
            ContrattoTrovato.setDescrizioneOfferta(contratto.getDescrizioneOfferta());
            ContrattoTrovato.setUtility(contratto.getUtility());
            ContrattoTrovato.setStatoContratto(contratto.getStatoContratto());
            ContrattoTrovato.setTipoPagamento(contratto.getTipoPagamento());
            ContrattoTrovato.setPotenzaImp(contratto.getPotenzaImp());
            ContrattoTrovato.setPotDisp(contratto.getPotDisp());
            return repository.save(ContrattoTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Contatto non trovato con l'id fornito")
        );
    }

    @Override
    public void delete(Long iDContratto) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDContratto);
        repository.deleteById(iDContratto);
    }
}
