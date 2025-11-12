package com.epass.epass_be.service;

import com.epass.epass_be.repository.AgendaRepository;
import com.epass.epass_be.model.Agenda;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Iterable<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(long id) {
        return agendaRepository.findById(id);
    }

    public void deleteById(long id) {
        agendaRepository.deleteById(id);
    }
    
}