package com.epass.epass_be.service;

import com.epass.epass_be.model.Nota;
import com.epass.epass_be.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota save(Nota nota) {
        return notaRepository.save(nota);
    }

    public Iterable<Nota> findAll() {
        return notaRepository.findAll();
    }

    public Optional<Nota> findById(long id) {
        return notaRepository.findById(id);
    }

    public void deleteById(long id) {
        notaRepository.deleteById(id);
    }
    
}