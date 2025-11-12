package com.epass.epass_be.controller;

import com.epass.epass_be.model.Agenda;
import com.epass.epass_be.service.AgendaService;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Agenda Controller")
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @Operation(summary = "Salva uma agenda no banco de dados")
    @PostMapping("/save")
    public Agenda save(@RequestBody Agenda agenda) {
        return agendaService.save(agenda);
    }

    @Operation(summary = "Atualiza uma agenda no banco de dados")
    @PostMapping("/update/{id}")
    public Agenda update(@PathVariable long id, @RequestBody Agenda a) {
        a.setId(id);
        Agenda nova_agenda = agendaService.save(a);
        return nova_agenda;
    }

    @Operation(summary = "Lista todas as agendas do banco de dados")
    @GetMapping("/findAll")
    public List<Agenda> findAll() {
        return (List<Agenda>) agendaService.findAll();
    }

    @Operation(summary = "Encontra uma agenda no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Agenda> findById(@PathVariable long id) {
        return agendaService.findById(id);
    }

    @Operation(summary = "Apaga uma agenda do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        agendaService.deleteById(id);
    }

}