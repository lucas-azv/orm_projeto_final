package iftm.edu.br.lead_manager_api.controller;

import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Funcionario;
import iftm.edu.br.lead_manager_api.service.FuncionarioService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
    FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> getAllFuncionarios() throws Exception {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable("id") Long id, @RequestBody Funcionario data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
