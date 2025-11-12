package com.epass.epass_be.service;

import com.epass.epass_be.repository.NotificacaoRepository;
import com.epass.epass_be.model.Notificacao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Iterable<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> findById(long id) {
        return notificacaoRepository.findById(id);
    }

    public void deleteById(long id) {
        notificacaoRepository.deleteById(id);
    }
    
}