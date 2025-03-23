package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposition,Long> {
}
