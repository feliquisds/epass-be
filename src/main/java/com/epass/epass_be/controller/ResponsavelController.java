package com.epass.epass_be.controller;
import com.epass.epass_be.model.Responsavel;
import com.epass.epass_be.service.ResponsavelService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Responsavel Controller")
@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private final ResponsavelService responsavelService;


    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @Operation(summary = "Salva um responsavel no banco de dados")
    @PostMapping("/save")
    public Responsavel save(@RequestBody Responsavel responsavel) {
        return responsavelService.save(responsavel);
    }

    @Operation(summary = "Atualiza um responsavel no banco de dados")
    @PostMapping("/update/{id}")
    public Responsavel update(@PathVariable long id, @RequestBody Responsavel a) {
        a.setId(id);
        Responsavel novo_responsavel = responsavelService.save(a);
        return novo_responsavel;
    }

    @Operation(summary = "Lista todos os responsavel do banco de dados")
    @GetMapping("/findAll")
    public Iterable<Responsavel> findAll() {
        return responsavelService.findAll();
    }

    @Operation(summary = "Encontra um responsavel no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Responsavel> findById(@PathVariable long id) {
        return responsavelService.findById(id);
    }

    @Operation(summary = "Apaga um responsavel do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        responsavelService.deleteById(id);
    }
}