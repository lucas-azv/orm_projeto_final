package iftm.edu.br.lead_manager_api.controller;

import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Cliente;
import iftm.edu.br.lead_manager_api.service.ClienteService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> getAllClientes() throws Exception {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cliente getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") Long id, @RequestBody Cliente data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
