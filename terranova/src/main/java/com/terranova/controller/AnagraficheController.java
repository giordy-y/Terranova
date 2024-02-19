package com.terranova.controller;

import com.terranova.exception.CustomException;
import com.terranova.model.entity.Anagrafica;
import com.terranova.service.AnagraficaService;
import com.terranova.exception.EsecuzioneErrataException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/anagrafiche")
public class AnagraficheController {
    @Autowired private final AnagraficaService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<Anagrafica>> getListaAnagrafica()
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId/{iDAnagrafica}")
    public ResponseEntity<Anagrafica> getAnagraficaByID(@PathVariable Long iDAnagrafica)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(iDAnagrafica));
    }
    @PostMapping(path = "createAnagrafica")
    public ResponseEntity<Anagrafica> createAnagrafica(@RequestBody Anagrafica Anagrafica)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(Anagrafica));
    }
    @PutMapping(path = "updateAnagrafica/{iDAnagrafica}")
    public ResponseEntity<Anagrafica> updateAnagrafica(@PathVariable Long iDAnagrafica,@RequestBody Anagrafica Anagrafica)
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.update(iDAnagrafica, Anagrafica));
    }
    @DeleteMapping(path = "deleteAnagrafica/{iDAnagrafica}")
    public void deleteAnagrafica(@PathVariable Long iDAnagrafica)
            throws IOException, CustomException{
        service.delete(iDAnagrafica);
    }

}


