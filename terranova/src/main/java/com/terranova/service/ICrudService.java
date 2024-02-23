package com.terranova.service;

import com.terranova.exception.ForeignKeyException;

import java.util.List;
import java.util.Optional;

/**
 * Interface for generic CRUD service
 *
 * @param <T> the domain type the repository manages
 * @param <P> the type of the id of the entity the repository manages
 */
public interface ICrudService<T, P> {
    List<T> findAll();

    T findById(P pk);

    T create(T t) throws ForeignKeyException;

    T update(P pk,T t) throws ForeignKeyException;

    void delete(P pk);
}
