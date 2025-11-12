package com.epass.epass_be.service;

import com.epass.epass_be.model.Disciplina;
import com.epass.epass_be.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Iterable<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(long id) {
        return disciplinaRepository.findById(id);
    }

    public void deleteById(long id) {
        disciplinaRepository.deleteById(id);
    }
    
}