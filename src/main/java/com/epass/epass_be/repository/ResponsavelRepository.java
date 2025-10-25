package com.epass.epass_be.repository;
import com.epass.epass_be.model.Responsavel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponsavelRepository extends CrudRepository<Responsavel, Long> {
    
}