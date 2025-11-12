package com.epass.epass_be.service;

import com.epass.epass_be.repository.ProfessorRepository;
import com.epass.epass_be.model.Professor;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Iterable<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(long id) {
        return professorRepository.findById(id);
    }

    public void deleteById(long id) {
        professorRepository.deleteById(id);
    }
    
}