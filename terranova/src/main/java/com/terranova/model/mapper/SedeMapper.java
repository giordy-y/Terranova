package com.terranova.model.mapper;

import com.terranova.model.dto.SedeDto;
import com.terranova.model.entity.Sede;

import java.util.List;

public class SedeMapper implements IDtoEntityBidirectionalMapper<SedeDto, Sede>{
    @Override
    public List<SedeDto> toDtos(List<Sede> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public SedeDto toDto(Sede sede) {
        return new SedeDto(
                sede.getIDSede(),
                sede.getAnagrafica(),
                sede.getDescrizione(),
                sede.getIndirizzo(),
                sede.getCivico(),
                sede.getCAP(),
                sede.getLocalita(),
                sede.getProvincia(),
                sede.getNazione()
        );
    }

    @Override
    public List<Sede> toEntities(List<SedeDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }

    @Override
    public Sede toEntity(SedeDto dto) {
        return new Sede(
                dto.getIDSede(),
                dto.getAnagrafica(),
                dto.getDescrizione(),
                dto.getIndirizzo(),
                dto.getCivico(),
                dto.getCAP(),
                dto.getLocalita(),
                dto.getProvincia(),
                dto.getNazione()
        );
    }
}
