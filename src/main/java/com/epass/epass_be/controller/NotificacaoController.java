package com.epass.epass_be.controller;

import com.epass.epass_be.model.Notificacao;
import com.epass.epass_be.service.NotificacaoService;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Notificacao Controller")
@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @Operation(summary = "Salva uma notificacao no banco de dados")
    @PostMapping("/save")
    public Notificacao save(@RequestBody Notificacao notificacao) {
        return notificacaoService.save(notificacao);
    }

    @Operation(summary = "Atualiza uma notificacao no banco de dados")
    @PostMapping("/update/{id}")
    public Notificacao update(@PathVariable long id, @RequestBody Notificacao notificacao) {
        notificacao.setId(id);
        return notificacaoService.save(notificacao);
    }

    @Operation(summary = "Lista todas as notificacaos do banco de dados")
    @GetMapping("/findAll")
    public List<Notificacao> findAll() {
        return (List<Notificacao>) notificacaoService.findAll();
    }

    @Operation(summary = "Encontra uma notificacao no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Notificacao> findById(@PathVariable long id) {
        return notificacaoService.findById(id);
    }

    @Operation(summary = "Apaga uma notificacao do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        notificacaoService.deleteById(id);
    }

}