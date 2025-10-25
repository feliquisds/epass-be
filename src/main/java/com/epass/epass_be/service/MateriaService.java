package com.epass.epass_be.service;

import com.epass.epass_be.model.Materia;
import com.epass.epass_be.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private final MateriaRepository materiaRepository;


    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;

        
    }

    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Iterable<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> findById(long id) {
        return materiaRepository.findById(id);
    }

    public void deleteById(long id) {
        materiaRepository.deleteById(id);
    }
}