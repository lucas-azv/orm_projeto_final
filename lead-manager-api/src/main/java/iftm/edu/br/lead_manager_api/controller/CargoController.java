package iftm.edu.br.lead_manager_api.controller;

import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Cargo;
import iftm.edu.br.lead_manager_api.service.CargoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Cargo")
public class CargoController {
    CargoService service;

    public CargoController(CargoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cargo> getAllCargos() throws Exception {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cargo getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public Cargo create(@RequestBody Cargo data) {
        return  service.create(data);
    }

    @PutMapping("/{id}")
    public Cargo update(@PathVariable("id") Long id, @RequestBody Cargo data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
