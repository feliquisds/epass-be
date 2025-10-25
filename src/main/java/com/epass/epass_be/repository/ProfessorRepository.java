package com.epass.epass_be.repository;
import com.epass.epass_be.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    
}