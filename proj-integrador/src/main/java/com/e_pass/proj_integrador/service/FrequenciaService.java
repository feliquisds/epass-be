package com.e_pass.proj_integrador.service;

import com.e_pass.proj_integrador.model.Frequencia;
import com.e_pass.proj_integrador.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrequenciaService {

    @Autowired
    private final FrequenciaRepository frequenciaRepository;

    public FrequenciaService(FrequenciaRepository frequenciaRepository) {
        this.frequenciaRepository = frequenciaRepository;
    }

    public Frequencia save(Frequencia frequencia) {
        return frequenciaRepository.save(frequencia);
    }

    public Iterable<Frequencia> findAll() {
        return frequenciaRepository.findAll();
    }

    public Optional<Frequencia> findById(long id) {
        return frequenciaRepository.findById(id);
    }

    public void deleteById(long id) {
        frequenciaRepository.deleteById(id);
    }
}