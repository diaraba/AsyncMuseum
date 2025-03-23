package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur,Long> {
}
