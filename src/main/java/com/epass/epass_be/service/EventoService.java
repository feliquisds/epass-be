package com.epass.epass_be.service;

import com.epass.epass_be.repository.EventoRepository;
import com.epass.epass_be.model.Evento;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Iterable<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> findById(long id) {
        return eventoRepository.findById(id);
    }

    public void deleteById(long id) {
        eventoRepository.deleteById(id);
    }
    
}