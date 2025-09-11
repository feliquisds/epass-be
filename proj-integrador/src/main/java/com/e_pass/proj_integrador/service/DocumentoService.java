package com.e_pass.proj_integrador.service;

import com.e_pass.proj_integrador.model.Documento;
import com.e_pass.proj_integrador.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private final DocumentoRepository documentoRepository;


    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;

        
    }

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Iterable<Documento> findAll() {
        return documentoRepository.findAll();
    }

    public Optional<Documento> findById(long id) {
        return documentoRepository.findById(id);
    }

    public void deleteById(long id) {
        documentoRepository.deleteById(id);
    }
}