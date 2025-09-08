package com.e_pass.proj_integrador.repository;
import com.e_pass.proj_integrador.model.Responsavel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponsavelRepository extends CrudRepository<Responsavel, Long> {
    
}