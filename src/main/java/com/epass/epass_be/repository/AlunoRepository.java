package com.epass.epass_be.repository;
import com.epass.epass_be.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    
}