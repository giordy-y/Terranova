package com.terranova.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface of a bidirectional mapper for a generic DTO to ENTITY and vice versa.
 *
 * @param <D> - DTO
 * @param <E> - ENTITY
 */
public interface IDtoEntityBidirectionalMapper<D, E> {

    /** Maps a list of entities to a list of dtos. */
    default List<D> toDtos(List<E> entityList) {
        return entityList != null
                ? entityList.stream().map(this::toDto).collect(Collectors.toList())
                : new ArrayList<>();
    }

    /** Maps an entity to a dto. */
    D toDto(E entity);

    /** Maps a list of dtos to a list of entities. */
    default List<E> toEntities(List<D> dtoList) {
        return dtoList != null
                ? dtoList.stream().map(this::toEntity).collect(Collectors.toList())
                : new ArrayList<>();
    }

    /** Maps a dto to an entity. */
    E toEntity(D dto);
}
