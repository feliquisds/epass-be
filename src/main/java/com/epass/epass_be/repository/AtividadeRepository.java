package com.epass.epass_be.repository;

import com.epass.epass_be.model.Atividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Long> {

}