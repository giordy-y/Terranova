package com.terranova.controller;

import com.terranova.exception.CustomException;
import com.terranova.model.entity.Sede;
import com.terranova.service.SedeService;
import com.terranova.exception.EsecuzioneErrataException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/sedi")
public class SediController {
    @Autowired private final SedeService service;

    @GetMapping(path = "tutti")
    public ResponseEntity<List<Sede>> getListaSede()
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "byId/{iDSede}")
    public ResponseEntity<Sede> getSedeByIDAnagrafica(@PathVariable Long iDSede)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.findById(iDSede));
    }
    @PostMapping(path = "createSede")
    public ResponseEntity<Sede> createSede(@RequestBody Sede sede)
            throws EsecuzioneErrataException{
        return ResponseEntity.ok(service.create(sede));
    }
    @PutMapping(path = "updateSede/{iDSede}")
    public ResponseEntity<Sede> updateSede(@PathVariable Long iDSede,@RequestBody Sede sede)
            throws EsecuzioneErrataException {
        return ResponseEntity.ok(service.update(iDSede, sede));
    }
    @DeleteMapping(path = "deleteSede/{iDSede}")
    public void deleteSede(@PathVariable Long iDSede)
            throws IOException, CustomException{
        service.delete(iDSede);
    }

}

