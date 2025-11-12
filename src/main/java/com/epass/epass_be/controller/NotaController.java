package com.epass.epass_be.controller;

import com.epass.epass_be.model.Nota;
import com.epass.epass_be.service.NotaService;
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

@Tag(name = "Nota Controller")
@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @Operation(summary = "Salva uma nota no banco de dados")
    @PostMapping("/save")
    public Nota save(@RequestBody Nota m) {
        Nota nova_nota = notaService.save(m);
        return nova_nota;
    }

    @Operation(summary = "Atualiza uma nota no banco de dados")
    @PostMapping("/update/{id}")
    public Nota update(@PathVariable long id, @RequestBody Nota m) {
        m.setId(id);
        Nota nova_nota = notaService.save(m);
        return nova_nota;
    }

    @Operation(summary = "Lista todas as notas do banco de dados")
    @GetMapping("/findAll")
    public List<Nota> findAll() {
        return (List<Nota>) notaService.findAll();
    }

    @Operation(summary = "Encontra uma nota no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Nota> findById(@PathVariable long id) {
        return notaService.findById(id);
    }

    @Operation(summary = "Apaga uma nota do banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        notaService.deleteById(id);
    }

}