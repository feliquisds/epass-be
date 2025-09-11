package com.e_pass.proj_integrador.controller;

import com.e_pass.proj_integrador.model.Documento;
import com.e_pass.proj_integrador.service.DocumentoService;

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

@Tag(name = "Documento Controller")
@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @Operation(summary = "Salva um documento no banco de dados")
    @PostMapping("/save")
    public Documento save(@RequestBody Documento d) {
        return documentoService.save(d);
    }

    @Operation(summary = "Atualiza um documento no banco de dados")
    @PostMapping("/update/{id}")
    public Documento update(@PathVariable long id, @RequestBody Documento d) {
        d.setID(id); // assumindo que o Documento possui o método setId
        return documentoService.save(d);
    }

    @Operation(summary = "Lista todos os documentos do banco de dados")
    @GetMapping("/findAll")
    public List<Documento> findAll() {
        return (List<Documento>) documentoService.findAll();
    }

    @Operation(summary = "Encontra um documento pelo ID")
    @GetMapping("/find/{id}")
    public Optional<Documento> findById(@PathVariable long id) {
        return documentoService.findById(id);
    }

    @Operation(summary = "Apaga um documento pelo ID")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        documentoService.deleteById(id);
    }
}