package com.epass.epass_be.controller;

import com.epass.epass_be.model.Evento;
import com.epass.epass_be.service.EventoService;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Evento Controller")
@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Operation(summary = "Salva um evento no banco de dados")
    @PostMapping("/save")
    public Evento save(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    @Operation(summary = "Atualiza um evento no banco de dados")
    @PostMapping("/update/{id}")
    public Evento update(@PathVariable long id, @RequestBody Evento a) {
        a.setId(id);
        Evento nova_evento = eventoService.save(a);
        return nova_evento;
    }

    @Operation(summary = "Lista todos os eventos do banco de dados")
    @GetMapping("/findAll")
    public List<Evento> findAll() {
        return (List<Evento>) eventoService.findAll();
    }

    @Operation(summary = "Encontra um evento no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Evento> findById(@PathVariable long id) {
        return eventoService.findById(id);
    }

    @Operation(summary = "Apaga um evento do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        eventoService.deleteById(id);
    }

}