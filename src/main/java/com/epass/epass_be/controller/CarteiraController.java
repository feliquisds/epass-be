package com.epass.epass_be.controller;

import com.epass.epass_be.model.Carteira;
import com.epass.epass_be.service.CarteiraService;
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

@Tag(name = "Carteira Controller")
@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Operation(summary = "Salva uma carteira no banco de dados")
    @PostMapping("/save")
    public Carteira save(@RequestBody Carteira carteira) {
        return carteiraService.save(carteira);
    }

    @Operation(summary = "Atualiza uma carteira no banco de dados")
    @PostMapping("/update/{id}")
    public Carteira update(@PathVariable long id, @RequestBody Carteira carteira) {
        carteira.setId(id);
        return carteiraService.save(carteira);
    }

    @Operation(summary = "Lista todas as carteiras do banco de dados")
    @GetMapping("/findAll")
    public List<Carteira> findAll() {
        return (List<Carteira>) carteiraService.findAll();
    }

    @Operation(summary = "Encontra uma carteira no banco de dados")
    @GetMapping("/find/{id}")
    public Optional<Carteira> findById(@PathVariable long id) {
        return carteiraService.findById(id);
    }

    @Operation(summary = "Apaga uma carteira no banco de dados")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        carteiraService.deleteById(id);
    }

}