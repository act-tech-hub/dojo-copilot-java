package com.act.techhub.api.controllers;

import com.act.techhub.api.model.Cliente;
import com.act.techhub.api.model.Produto;
import com.act.techhub.api.service.ClienteService;
import com.act.techhub.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produtos", description = "API de Gerenciamento de produtos")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca um produto pelo ID",
            responses = {
                    @ApiResponse(description = "Produto encontrado", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
            })
    public ResponseEntity getProdutoById(
            @Parameter(description = "ID do produto para buscar", required = true)
            @PathVariable int id) {
        Produto produto = produtoService.getProdutoByIdList(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os Produtos")
    public ResponseEntity getAllProdutos() {
        System.out.println("chamando método getAllProdutos");
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<String> addCliente(@RequestBody Produto produto) {
        produtoService.addProduto(produto);
        return ResponseEntity.ok("Produto adicionado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduto(@PathVariable int id, @RequestBody Produto updatedProduto) {
        if (produtoService.getProdutoById(id).isPresent()) {
            produtoService.updateProduto(id, updatedProduto);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable int id) {
        if (produtoService.getProdutoById(id).isPresent()) {
            produtoService.deleteCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
