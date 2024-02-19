package com.terranova.model.mapper;

import com.terranova.model.dto.AnagraficaDto;
import com.terranova.model.entity.Anagrafica;

import java.util.List;

public class AnagraficheMapper implements IDtoEntityBidirectionalMapper<AnagraficaDto, Anagrafica> {

    @Override
    public List<AnagraficaDto> toDtos(List<Anagrafica> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public AnagraficaDto toDto(Anagrafica anagrafica) {
        return new AnagraficaDto(
                anagrafica.getIDAnagrafica(),
                anagrafica.getNome(),
                anagrafica.getCognome(),
                anagrafica.getRagSoc(),
                anagrafica.getPIVA(),
                anagrafica.getCFisc(),
                anagrafica.getIndirizzo(),
                anagrafica.getCivico(),
                anagrafica.getCAP(),
                anagrafica.getLocalita(),
                anagrafica.getProvincia(),
                anagrafica.getNazione(),
                anagrafica.getNumeroTelefonico(),
                anagrafica.getEmail()
        );
    }

    @Override
    public List<Anagrafica> toEntities(List<AnagraficaDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }

    @Override
    public Anagrafica toEntity(AnagraficaDto dto) {
        return new Anagrafica(
                dto.getIDAnagrafica(),
                dto.getNome(),
                dto.getCognome(),
                dto.getRagSoc(),
                dto.getPIVA(),
                dto.getCFisc(),
                dto.getIndirizzo(),
                dto.getCivico(),
                dto.getCAP(),
                dto.getLocalita(),
                dto.getProvincia(),
                dto.getNazione(),
                dto.getNumeroTelefonico(),
                dto.getEmail()
        );
    }
}
