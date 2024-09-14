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

import iftm.edu.br.lead_manager_api.model.Representado;
import iftm.edu.br.lead_manager_api.service.RepresentadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Representado", description = "API de gerenciamento de representados")
@RequestMapping("/Representado")
public class RepresentadoController {
    RepresentadoService service;

    public RepresentadoController(RepresentadoService service) {
        this.service = service;
    }

    @Operation(summary = "Retornar todos os representados", description = "Retorna uma lista com todos os representados cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de representados retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping
    public List<Representado> getAllRepresentados() throws Exception {
        return service.getAll();
    }

    @Operation(summary = "Retornar um representado", description = "Retorna um representado específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Representado retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Representado não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/{id}")
    public Representado getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @Operation(summary = "Criar um representado", description = "Cria um novo representado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Representado criado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PostMapping
    public Representado create(@RequestBody Representado data) {
        return service.create(data);
    }

    @Operation(summary = "Atualizar um representado", description = "Atualiza um representado existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Representado atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Representado não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PutMapping("/{id}")
    public Representado update(@PathVariable("id") Long id, @RequestBody Representado data) {
        return service.update(id, data);
    }

    @Operation(summary = "Deletar um representado", description = "Deleta um representado existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Representado deletado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
