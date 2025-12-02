package com.epass.epass_be.service;

import com.epass.epass_be.model.Carteira;
import com.epass.epass_be.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CarteiraService {

    @Autowired
    private final CarteiraRepository CarteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.CarteiraRepository = carteiraRepository;
    }

    public Carteira save(Carteira carteira) {
        return CarteiraRepository.save(carteira);
    }

    public Iterable<Carteira> findAll() {
        return CarteiraRepository.findAll();
    }

    public Optional<Carteira> findById(long id) {
        return CarteiraRepository.findById(id);
    }

    public void deleteById(long id) {
        CarteiraRepository.deleteById(id);
    }

    public Optional<Carteira> buscarCarteiraPorAlunoId(Long alunoId) {
        return CarteiraRepository.findByAlunoId(alunoId);
    }
}