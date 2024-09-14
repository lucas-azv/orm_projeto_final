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

import iftm.edu.br.lead_manager_api.model.Endereco;
import iftm.edu.br.lead_manager_api.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Endereco", description = "API de gerenciamento de endereços")
@RequestMapping("/Endereco")
public class EnderecoController {
    EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @Operation(summary = "Retornar todos os endereços", description = "Retorna uma lista com todos os endereços cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de endereços retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping
    public List<Endereco> getAllEnderecos() throws Exception {
        return service.getAll();
    }

    @Operation(summary = "Retornar um endereço", description = "Retorna um endereço específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @GetMapping("/{id}")
    public Endereco getMethodName(@PathVariable("id") Long id) throws Exception {
        return service.getById(id);
    }

    @Operation(summary = "Criar um endereço", description = "Cria um novo endereço")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço criado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PostMapping
    public Endereco create(@RequestBody Endereco data) {
        return service.create(data);
    }

    @Operation(summary = "Atualizar um endereço", description = "Atualiza um endereço existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @PutMapping("/{id}")
    public Endereco update(@PathVariable("id") Long id, @RequestBody Endereco data) {
        return service.update(id, data);
    }

    @Operation(summary = "Deletar um endereço", description = "Deleta um endereço existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro")
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

}
