package com.e_pass.proj_integrador.repository;
import com.e_pass.proj_integrador.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    
}