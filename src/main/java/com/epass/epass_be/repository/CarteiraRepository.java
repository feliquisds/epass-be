package com.epass.epass_be.repository;

import com.epass.epass_be.model.Carteira;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends CrudRepository<Carteira, Long> {

    Optional<Carteira> findByAlunoId(Long AlunoId);

}