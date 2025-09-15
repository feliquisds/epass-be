package com.e_pass.proj_integrador.service;

import com.e_pass.proj_integrador.model.Atividade;
import com.e_pass.proj_integrador.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private final AtividadeRepository atividadeRepository;


    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
        
    }

    public Atividade save(Atividade aluno) {
        return atividadeRepository.save(aluno);
    }

    public Iterable<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> findById(long id) {
        return atividadeRepository.findById(id);
    }

    public void deleteById(long id) {
        atividadeRepository.deleteById(id);
    }
}