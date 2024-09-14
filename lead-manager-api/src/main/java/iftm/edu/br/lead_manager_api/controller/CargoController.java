package iftm.edu.br.lead_manager_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.lead_manager_api.model.Cargo;
import iftm.edu.br.lead_manager_api.service.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Cargo", description = "API de gerenciamento de cargos")
@RequestMapping("/Cargo")
public class CargoController {
    CargoService service;

    public CargoController(CargoService service) {
        this.service = service;
    }

    @Operation(summary = "Retornar todos os cargos", description = "Retorna uma lista com todos os cargos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de cargos retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping
    public List<Cargo> getAllCargos() throws Exception {
        return service.getAll();
    }

    @Operation(summary = "Retornar um cargo", description = "Retorna um cargo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cargo retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cargo não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/{id}")
    public Cargo getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @Operation(summary = "Criar um cargo", description = "Cria um novo cargo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cargo criado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PostMapping
    public Cargo create(@RequestBody Cargo data) {
        return  service.create(data);
    }

    @Operation(summary = "Atualizar um cargo", description = "Atualiza um cargo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cargo atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cargo não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PutMapping("/{id}")
    public Cargo update(@PathVariable("id") Long id, @RequestBody Cargo data) {
        return service.update(id, data);
    }

    @Operation(summary = "Deletar um cargo", description = "Deleta um cargo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cargo deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cargo não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
