package com.terranova.model.mapper;

import com.terranova.model.dto.ContattoDto;
import com.terranova.model.entity.Contatto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContattoMapper implements IDtoEntityBidirectionalMapper<ContattoDto,Contatto> {

    @Override
    public ContattoDto toDto(Contatto Contatto) {
        return new ContattoDto(
                Contatto.getIDContatto(),
                Contatto.getIDAnagrafica(),
                Contatto.getNome(),
                Contatto.getCognome(),
                Contatto.getRagSoc(),
                Contatto.getPIVA(),
                Contatto.getCFisc(),
                Contatto.getIndirizzo(),
                Contatto.getCivico(),
                Contatto.getCAP(),
                Contatto.getLocalita(),
                Contatto.getProvincia(),
                Contatto.getNazione(),
                Contatto.getNumeroTelefonico(),
                Contatto.getEmail()
        );
    }

    @Override
    public List<ContattoDto> toDtos(List<Contatto> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }



    @Override
    public Contatto toEntity(ContattoDto ContattoDto) {
        return new Contatto(
                ContattoDto.getIDContatto(),
                ContattoDto.getIDAnagrafica(),
                ContattoDto.getNome(),
                ContattoDto.getCognome(),
                ContattoDto.getRagSoc(),
                ContattoDto.getPIVA(),
                ContattoDto.getCFisc(),
                ContattoDto.getIndirizzo(),
                ContattoDto.getCivico(),
                ContattoDto.getCAP(),
                ContattoDto.getLocalita(),
                ContattoDto.getProvincia(),
                ContattoDto.getNazione(),
                ContattoDto.getNumeroTelefonico(),
                ContattoDto.getEmail()
        );
    }
    @Override
    public List<Contatto> toEntities(List<ContattoDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
