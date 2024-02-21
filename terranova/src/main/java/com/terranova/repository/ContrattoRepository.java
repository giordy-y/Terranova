package com.terranova.repository;

import com.terranova.model.entity.Contratto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrattoRepository extends JpaRepository<Contratto,Long> {
}
