package com.e_pass.proj_integrador.service;
import com.e_pass.proj_integrador.repository.ResponsavelRepository;
import com.e_pass.proj_integrador.model.Responsavel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    @Autowired
    private final ResponsavelRepository responsavelRepository;

    public ResponsavelService(ResponsavelRepository responsavelRepository) {
        this.responsavelRepository = responsavelRepository;
    }

    public Responsavel save(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public Iterable<Responsavel> findAll() {
        return responsavelRepository.findAll();
    }

    public Optional<Responsavel> findById(long id) {
        return responsavelRepository.findById(id);
    }

      public void deleteById(long id) {
        responsavelRepository.deleteById(id);
    }
}