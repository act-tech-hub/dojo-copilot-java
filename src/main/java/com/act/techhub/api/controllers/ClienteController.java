package com.act.techhub.api.controllers;

import com.act.techhub.api.controllers.request.ClienteRequest;
import com.act.techhub.api.model.Cliente;

import com.act.techhub.api.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Cliente", tags = {"Cliente Controller"}, protocols = "http")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um cliente pelo ID", response = Cliente.class)
    public ResponseEntity getClienteById(
            @ApiParam(value = "ID do cliente para buscar", required = true)
            @PathVariable int id) {
        Cliente cliente = clienteService.getClienteByIdList(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os clientes", response = Cliente.class, responseContainer = "List")
    public ResponseEntity getAllClientes() {
        System.out.println("chamando método getAllClientes");
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar um cliente", response = String.class)
    public ResponseEntity<String> addCliente(@RequestBody ClienteRequest request) {
        clienteService.addCliente(request);
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
