package com.terranova.controller;

import com.terranova.exception.CustomException;
import com.terranova.model.entity.Contatto;
import com.terranova.service.ContattoService;
import com.terranova.exception.EsecuzioneErrataException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/contatti")
public class ContattiController {
    @Autowired private final ContattoService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<Contatto>> getListaContatto()
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId/{iDcontatto}")
    public ResponseEntity<Contatto> getContattoByIDAnagrafica(@PathVariable Long iDcontatto)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(iDcontatto));
    }
    @PostMapping(path = "createContatto")
    public ResponseEntity<Contatto> createContatto(@RequestBody Contatto Contatto)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(Contatto));
    }
    @PutMapping(path = "updateContatto/{iDcontatto}")
    public ResponseEntity<Contatto> updateContatto(@PathVariable Long iDcontatto,@RequestBody Contatto Contatto)
        throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.update(iDcontatto, Contatto));
    }
    @DeleteMapping(path = "deleteContatto/{iDcontatto}")
    public void deleteContatto(@PathVariable Long iDcontatto)
        throws IOException, CustomException{
        service.delete(iDcontatto);
    }

}

