package com.epass.epass_be.controller;

import com.epass.epass_be.model.Disciplina;
import com.epass.epass_be.service.DisciplinaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Disciplina Controller")
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @Operation(summary = "Salva uma disciplina no banco de dados")
    @PostMapping("/save")
    public Disciplina save(@RequestBody Disciplina disciplina) {
        return disciplinaService.save(disciplina);
    }

    @Operation(summary = "Atualiza uma disciplina no banco de dados")
    @PostMapping("/update/{id}")
    public Disciplina update(@PathVariable long id, @RequestBody Disciplina disciplina) {
        disciplina.setId(id);
        return disciplinaService.save(disciplina);
    }

    @Operation(summary = "Lista todas as disciplinas do banco de dados")
    @GetMapping("/findAll")
    public List<Disciplina> findAll() {
        return (List<Disciplina>) disciplinaService.findAll();
    }

    @Operation(summary = "Encontra uma disciplina no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Disciplina> findById(@PathVariable long id) {
        return disciplinaService.findById(id);
    }

    @Operation(summary = "Apaga uma disciplina do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        disciplinaService.deleteById(id);
    }

}