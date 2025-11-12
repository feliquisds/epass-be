package com.epass.epass_be.controller;

import com.epass.epass_be.model.Aula;
import com.epass.epass_be.service.AulaService;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Aula Controller")
@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @Operation(summary = "Salva uma aula no banco de dados")
    @PostMapping("/save")
    public Aula save(@RequestBody Aula aula) {
        return aulaService.save(aula);
    }

    @Operation(summary = "Atualiza uma aula no banco de dados")
    @PostMapping("/update/{id}")
    public Aula update(@PathVariable long id, @RequestBody Aula aula) {
        aula.setId(id);
        return aulaService.save(aula);
    }

    @Operation(summary = "Lista todas as aulas do banco de dados")
    @GetMapping("/findAll")
    public List<Aula> findAll() {
        return (List<Aula>) aulaService.findAll();
    }

    @Operation(summary = "Encontra uma aula no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Aula> findById(@PathVariable long id) {
        return aulaService.findById(id);
    }

    @Operation(summary = "Apaga uma aula do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        aulaService.deleteById(id);
    }

}