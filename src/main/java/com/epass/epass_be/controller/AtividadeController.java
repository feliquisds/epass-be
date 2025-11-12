package com.epass.epass_be.controller;

import com.epass.epass_be.model.Atividade;
import com.epass.epass_be.service.AtividadeService;
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

@Tag(name = "Atividade Controller")
@RestController
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @Operation(summary = "Salva uma atividade no banco de dados")
    @PostMapping("/save")
    public Atividade save(@RequestBody Atividade a) {
        Atividade nova_atividade = atividadeService.save(a);
        return nova_atividade;
    }

    @Operation(summary = "Atualiza uma atividade no banco de dados")
    @PostMapping("/update/{id}")
    public Atividade update(@PathVariable long id, @RequestBody Atividade a) {
        a.setId(id);
        return atividadeService.save(a);
    }

    @Operation(summary = "Lista todas as atividades do banco de dados")
    @GetMapping("/findAll")
    public List<Atividade> findAll() {
        return (List<Atividade>) atividadeService.findAll();
    }

    @Operation(summary = "Encontra uma atividade no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Atividade> findById(@PathVariable long id) {
        return atividadeService.findById(id);
    }

    @Operation(summary = "Apaga uma atividade do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        atividadeService.deleteById(id);
    }

}