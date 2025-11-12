package com.epass.epass_be.repository;

import com.epass.epass_be.model.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Long> {

}