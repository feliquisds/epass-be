package com.epass.epass_be.service;

import com.epass.epass_be.repository.TurmaRepository;
import com.epass.epass_be.model.Turma;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Iterable<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(long id) {
        return turmaRepository.findById(id);
    }

    public void deleteById(long id) {
        turmaRepository.deleteById(id);
    }
    
}