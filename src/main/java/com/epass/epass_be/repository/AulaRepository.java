package com.epass.epass_be.repository;

import com.epass.epass_be.model.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Long> {
    
}