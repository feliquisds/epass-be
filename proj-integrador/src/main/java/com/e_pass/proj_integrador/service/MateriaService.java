package com.e_pass.proj_integrador.service;

import com.e_pass.proj_integrador.model.Materia;
import com.e_pass.proj_integrador.repository.MateriaRepository;
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