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

import iftm.edu.br.lead_manager_api.model.Funcionario;
import iftm.edu.br.lead_manager_api.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Funcionario", description = "API de gerenciamento de funcionários")
@RequestMapping("/Funcionario")
public class FuncionarioController {
    FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @Operation(summary = "Retornar todos os funcionários", description = "Retorna uma lista com todos os funcionários cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping
    public List<Funcionario> getAllFuncionarios() throws Exception {
        return service.getAll();
    }

    @Operation(summary = "Retornar um funcionário", description = "Retorna um funcionário específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Funcionário retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Funcionário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/{id}")
    public Funcionario getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @Operation(summary = "Criar um funcionário", description = "Cria um novo funcionário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Funcionário criado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PostMapping
    public Funcionario create(@RequestBody Funcionario data) {
        return service.create(data);
    }

    @Operation(summary = "Atualizar um funcionário", description = "Atualiza um funcionário existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Funcionário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PutMapping("/{id}")
    public Funcionario update(@PathVariable("id") Long id, @RequestBody Funcionario data) {
        return service.update(id, data);
    }

    @Operation(summary = "Deletar um funcionário", description = "Deleta um funcionário existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Funcionário deletado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
