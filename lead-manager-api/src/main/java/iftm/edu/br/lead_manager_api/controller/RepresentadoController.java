package iftm.edu.br.lead_manager_api.controller;

import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Representado;
import iftm.edu.br.lead_manager_api.service.RepresentadoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Representado")
public class RepresentadoController {
    RepresentadoService service;

    public RepresentadoController(RepresentadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Representado> getAllRepresentados() throws Exception {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Representado getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public Representado create(@RequestBody Representado data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public Representado update(@PathVariable("id") Long id, @RequestBody Representado data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
