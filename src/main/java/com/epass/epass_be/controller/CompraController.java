package com.epass.epass_be.controller;

import com.epass.epass_be.model.Compra;
import com.epass.epass_be.service.CompraService;
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

@Tag(name = "Compra Controller")
@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @Operation(summary = "Salva uma compra no banco de dados")
    @PostMapping("/save")
    public Compra save(@RequestBody Compra compra) {
        return compraService.save(compra);
    }

    @Operation(summary = "Atualiza uma compra no banco de dados")
    @PostMapping("/update/{id}")
    public Compra update(@PathVariable long id, @RequestBody Compra compra) {
        compra.setId(id);
        return compraService.save(compra);
    }

    @Operation(summary = "Lista todas as compras do banco de dados")
    @GetMapping("/findAll")
    public List<Compra> findAll() {
        return (List<Compra>) compraService.findAll();
    }

    @Operation(summary = "Encontra uma compra pelo ID")
    @GetMapping("/find/{id}")
    public Optional<Compra> findById(@PathVariable long id) {
        return compraService.findById(id);
    }

    @Operation(summary = "Apaga uma compra pelo ID")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        compraService.deleteById(id);
    }

}