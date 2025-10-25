package com.epass.epass_be.repository;
import com.epass.epass_be.model.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {
    
}