package com.terranova.service;

import com.terranova.exception.ContattoNotFoundException;
import com.terranova.model.entity.Anagrafica;
import com.terranova.repository.AnagraficaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaService implements ICrudService<Anagrafica,Long> {
    private static final String TABLE_NAME="Anagrafiche";

    protected static final Logger logger = LoggerFactory.getLogger(AnagraficaService.class);

    @Autowired protected AnagraficaRepository repository;

    @Override
    public List<Anagrafica> findAll() {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.findAll();
    }

    @Override
    public Anagrafica findById(Long iDAnagrafica) {
        logger.debug(
                "The method findByID has been invoked for the table {}, with parameter ID = {}",
                TABLE_NAME,
                iDAnagrafica);
        return  repository.findById(iDAnagrafica).orElseThrow(()->new ContattoNotFoundException("nussun Contatto presente con questo IDAnagrafica"));
    }

    @Override
    public Anagrafica create(Anagrafica anagrafica) {
        logger.debug(
                "The method create has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                anagrafica);
        return repository.save(anagrafica);
    }

    @Override
    public Anagrafica update(Long iDAnagrafica, Anagrafica anagrafica) {
        logger.debug("The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDAnagrafica);
        return repository.findById(iDAnagrafica).map(AnagraficaTrovato->{
            AnagraficaTrovato.setNome(anagrafica.getNome());
            AnagraficaTrovato.setCognome(anagrafica.getCognome());
            AnagraficaTrovato.setRagSoc(anagrafica.getRagSoc());
            AnagraficaTrovato.setPIVA(anagrafica.getPIVA());
            AnagraficaTrovato.setCFisc(anagrafica.getCFisc());
            AnagraficaTrovato.setIndirizzo(anagrafica.getIndirizzo());
            AnagraficaTrovato.setCivico(anagrafica.getCivico());
            AnagraficaTrovato.setCAP(anagrafica.getCAP());
            AnagraficaTrovato.setLocalita(anagrafica.getLocalita());
            AnagraficaTrovato.setProvincia(anagrafica.getProvincia());
            AnagraficaTrovato.setNazione(anagrafica.getNazione());
            AnagraficaTrovato.setNumeroTelefonico(anagrafica.getNumeroTelefonico());
            AnagraficaTrovato.setEmail(anagrafica.getEmail());
            return repository.save(AnagraficaTrovato);
        }).orElseThrow(
                ()-> new ContattoNotFoundException("Contatto non trovato con l'IDAnagrafica fornito")
        );
    }

    @Override
    public void delete(Long iDAnagrafica) {
        logger.debug(
                "The method delete has been invoked for the table {}, with parameter model = {}",
                TABLE_NAME,
                iDAnagrafica);
        repository.deleteById(iDAnagrafica);
    }
}
