package com.epass.epass_be.service;

import com.epass.epass_be.repository.AulaRepository;
import com.epass.epass_be.model.Aula;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaService {

    @Autowired
    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public Aula save(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Iterable<Aula> findAll() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> findById(long id) {
        return aulaRepository.findById(id);
    }

    public void deleteById(long id) {
        aulaRepository.deleteById(id);
    }
    
}