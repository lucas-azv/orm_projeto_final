package iftm.edu.br.lead_manager_api.controller;

import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Representante;
import iftm.edu.br.lead_manager_api.service.RepresentanteService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Representante")
public class RepresentanteController {
    RepresentanteService service;

    public RepresentanteController(RepresentanteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Representante> getAllRepresentantes() throws Exception {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Representante getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public Representante create(@RequestBody Representante data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public Representante update(@PathVariable("id") Long id, @RequestBody Representante data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
