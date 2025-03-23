package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.Musee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseeRepository extends JpaRepository<Musee,Long> {
}
