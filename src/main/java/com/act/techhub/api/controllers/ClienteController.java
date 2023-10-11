package com.act.techhub.api.controllers;

import com.act.techhub.api.model.Cliente;

import com.act.techhub.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "API de Gerenciamento de clientes")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo ID",
            responses = {
                    @ApiResponse(description = "Cliente encontrado", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
            })
    public ResponseEntity getClienteById(
            @Parameter(description = "ID do cliente para buscar", required = true)
            @PathVariable int id) {
        Cliente cliente = clienteService.getClienteByIdList(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    @Operation(summary = "Listar todos os Clientes")
    public ResponseEntity getAllClientes() {
        System.out.println("chamando método getAllClientes");
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<String> addCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
        return ResponseEntity.ok("Cliente adicionado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable int id, @RequestBody Cliente updatedCliente) {
        if (clienteService.getClienteById(id).isPresent()) {
            clienteService.updateCliente(id, updatedCliente);
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id) {
        if (clienteService.getClienteById(id).isPresent()) {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
