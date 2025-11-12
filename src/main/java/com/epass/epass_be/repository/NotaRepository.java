package com.epass.epass_be.repository;

import com.epass.epass_be.model.Nota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {

}