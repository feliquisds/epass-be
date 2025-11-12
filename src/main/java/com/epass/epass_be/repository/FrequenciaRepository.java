package com.epass.epass_be.repository;

import com.epass.epass_be.model.Frequencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequenciaRepository extends CrudRepository<Frequencia, Long> {

}