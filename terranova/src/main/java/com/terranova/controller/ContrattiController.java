package com.terranova.controller;

import com.terranova.exception.EsecuzioneErrataException;
import com.terranova.model.entity.Contratto;
import com.terranova.service.ContrattoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path="/api/contratti")
public class ContrattiController {
    @Autowired private final ContrattoService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<Contratto>> getListaContratto()
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId/{iDContratto}")
    public ResponseEntity<Contratto> getContrattoById(@PathVariable Long iDContratto)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(iDContratto));
    }
    @PostMapping(path = "createContratto")
    public ResponseEntity<Contratto> createContratto(@RequestBody Contratto contratto)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(contratto));
    }
    @PutMapping(path = "updateContratto/{iDContratto}")
    public ResponseEntity<Contratto> updateContratto(@PathVariable Long iDContratto, @RequestBody Contratto contratto)
        throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.update(iDContratto,contratto));
    }
    @DeleteMapping(path = "deleteContratto/{iDContratto}")
    public void deleteContratto(@PathVariable Long iDContratto)
        throws EsecuzioneErrataException{
        service.delete(iDContratto);
    }
}
