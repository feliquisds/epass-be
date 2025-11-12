package com.epass.epass_be.repository;

import com.epass.epass_be.model.Notificacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends CrudRepository<Notificacao, Long> {

}