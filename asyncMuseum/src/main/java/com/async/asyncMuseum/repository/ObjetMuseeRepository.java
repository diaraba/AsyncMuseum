package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.ObjetMusee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetMuseeRepository extends JpaRepository<ObjetMusee,Long> {
}
