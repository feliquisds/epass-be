package com.epass.epass_be.controller;
import com.epass.epass_be.model.Materia;
import com.epass.epass_be.service.MateriaService;

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

@Tag(name = "Materia Controller")
@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @Operation(summary = "Salva uma materia no banco de dados")
    @PostMapping("/save")
    public Materia save(@RequestBody Materia m) {
        Materia nova_materia = materiaService.save(m);
        return nova_materia;
    }
    
    @Operation(summary = "Atualiza uma materia no banco de dados")
    @PostMapping("/update/{id}")
    public Materia update(@PathVariable long id, @RequestBody Materia m) {
        m.setID(id);
        Materia nova_materia = materiaService.save(m);
        return nova_materia;
    }
    
    @Operation(summary = "Lista todas materias do banco de dados")
    @GetMapping("/findAll")
    public List<Materia> findAll() {
        return (List<Materia>) materiaService.findAll();
    }
    
    @Operation(summary = "Encontra uma materia no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Materia> findById(@PathVariable long id) {
        return materiaService.findById(id);
    }
    
    @Operation(summary = "Apaga uma materia do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        materiaService.deleteById(id);
    }
}