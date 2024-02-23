package com.terranova.model.mapper;

import com.terranova.model.entity.Contratto;
import com.terranova.model.dto.ContrattoDto;

import java.util.List;

public class ContrattoMapper implements  IDtoEntityBidirectionalMapper<ContrattoDto,Contratto>{


    @Override
    public List<ContrattoDto> toDtos(List<Contratto> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public ContrattoDto toDto(Contratto contratto) {
        return new ContrattoDto(
                contratto.getIDRigaContratto(),
                contratto.getSede(),
                contratto.getDatatRichiestaServizio(),
                contratto.getDataInizioValidita(),
                contratto.getDataFineValidita(),
                contratto.getDescrizioneOfferta(),
                contratto.getUtility(),
                contratto.getStatoContratto(),
                contratto.getTipoPagamento(),
                contratto.getPotenzaImp(),
                contratto.getPotDisp(),
                contratto.getEnergiaAnno(),
                contratto.getGasAnno(),
                contratto.getUsoCotturaCibi(),
                contratto.getProduzioneAcquaCaldaSanitaria(),
                contratto.getRiscaldamentoIndividuale(),
                contratto.getUsoCommerciale()
        );
    }

    @Override
    public List<Contratto> toEntities(List<ContrattoDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }

    @Override
    public Contratto toEntity(ContrattoDto dto) {
        return new Contratto(
                dto.getIDRigaContratto(),
                dto.getSede(),
                dto.getDatatRichiestaServizio(),
                dto.getDataInizioValidita(),
                dto.getDataFineValidita(),
                dto.getDescrizioneOfferta(),
                dto.getUtility(),
                dto.getStatoContratto(),
                dto.getTipoPagamento(),
                dto.getPotenzaImp(),
                dto.getPotDisp(),
                dto.getEnergiaAnno(),
                dto.getGasAnno(),
                dto.getUsoCotturaCibi(),
                dto.getProduzioneAcquaCaldaSanitaria(),
                dto.getRiscaldamentoIndividuale(),
                dto.getUsoCommerciale()
        );

    }
}
