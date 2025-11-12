package com.epass.epass_be.service;

import com.epass.epass_be.model.Atividade;
import com.epass.epass_be.repository.AtividadeRepository;
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

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
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