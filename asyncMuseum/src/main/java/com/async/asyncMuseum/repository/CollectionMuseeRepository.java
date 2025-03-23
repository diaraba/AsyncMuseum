package com.async.asyncMuseum.repository;

import com.async.asyncMuseum.model.CollectionMusee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionMuseeRepository extends JpaRepository<CollectionMusee,Long> {
}
