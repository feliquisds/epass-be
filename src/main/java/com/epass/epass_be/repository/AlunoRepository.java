package com.epass.epass_be.repository;

import com.epass.epass_be.model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    @Query(value = "SELECT a.* FROM aluno a JOIN responsavel_alunos ar ON a.id = ar.alunos_id WHERE ar.responsavel_id = :responsavelId", nativeQuery = true)
    List<Aluno> findAllByResponsavel(@Param("responsavelId") long responsavelId);
}