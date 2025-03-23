package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraireRepository extends JpaRepository<Horaire,Long> {
}
