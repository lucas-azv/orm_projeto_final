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

import iftm.edu.br.lead_manager_api.model.Representante;
import iftm.edu.br.lead_manager_api.service.RepresentanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Representante", description = "API de gerenciamento de representantes")
@RequestMapping("/Representante")
public class RepresentanteController {
    RepresentanteService service;

    public RepresentanteController(RepresentanteService service) {
        this.service = service;
    }

    @Operation(summary = "Retornar todos os representantes", description = "Retorna uma lista com todos os representantes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de representantes retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping
    public List<Representante> getAllRepresentantes() throws Exception {
        return service.getAll();
    }

    @Operation(summary = "Retornar um representante", description = "Retorna um representante específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representante retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Representante não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/{id}")
    public Representante getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @Operation(summary = "Retornar um representante por CNPJ", description = "Retorna um representante específico pelo CNPJ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representante retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Representante não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/cnpj/{cnpj}")
    public Representante getByCnpj(@PathVariable("cnpj") String cnpj) throws Exception {
        return service.findByCnpj(cnpj)
                .orElseThrow(() -> new Exception("Representante com CNPJ " + cnpj + " não encontrado"));
    }

    @Operation(summary = "Criar um representante", description = "Cria um novo representante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representante criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PostMapping
    public Representante create(@RequestBody Representante data) {
        return service.create(data);
    }

    @Operation(summary = "Atualizar um representante", description = "Atualiza um representante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representante atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Representante não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PutMapping("/{id}")
    public Representante update(@PathVariable("id") Long id, @RequestBody Representante data) {
        return service.update(id, data);
    }

    @Operation(summary = "Deletar um representante", description = "Deleta um representante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Representante deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro")
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
