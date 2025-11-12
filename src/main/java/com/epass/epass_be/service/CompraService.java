package com.epass.epass_be.service;

import com.epass.epass_be.model.Compra;
import com.epass.epass_be.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private final CompraRepository CompraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.CompraRepository = compraRepository;
    }

    public Compra save(Compra compra) {
        return CompraRepository.save(compra);
    }

    public Iterable<Compra> findAll() {
        return CompraRepository.findAll();
    }

    public Optional<Compra> findById(long id) {
        return CompraRepository.findById(id);
    }

    public void deleteById(long id) {
        CompraRepository.deleteById(id);
    }
    
}