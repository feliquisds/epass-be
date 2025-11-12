package com.epass.epass_be.controller;

import com.epass.epass_be.model.Frequencia;
import com.epass.epass_be.service.FrequenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Frequencia Controller")
@RestController
@RequestMapping("/frequencia")
public class FrequenciaController {

    @Autowired
    private final FrequenciaService frequenciaService;

    public FrequenciaController(FrequenciaService frequenciaService) {
        this.frequenciaService = frequenciaService;
    }

    @Operation(summary = "Salva uma frequência no banco de dados")
    @PostMapping("/save")
    public Frequencia save(@RequestBody Frequencia frequencia) {
        return frequenciaService.save(frequencia);
    }

    @Operation(summary = "Atualiza uma frequência no banco de dados")
    @PostMapping("/update/{id}")
    public Frequencia update(@PathVariable long id, @RequestBody Frequencia frequencia) {
        frequencia.setId(id);
        return frequenciaService.save(frequencia);
    }

    @Operation(summary = "Lista todas as frequências")
    @GetMapping("/findAll")
    public List<Frequencia> findAll() {
        return (List<Frequencia>) frequenciaService.findAll();
    }

    @Operation(summary = "Encontra uma frequência no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Frequencia> findById(@PathVariable long id) {
        return frequenciaService.findById(id);
    }

    @Operation(summary = "Apaga uma frequência no banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        frequenciaService.deleteById(id);
    }

}