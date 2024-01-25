package com.terranova.service;

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

    Optional<T> findById(P pk);

    T create(T user);

    T update(P pk,T user);

    void delete(P pk);
}
