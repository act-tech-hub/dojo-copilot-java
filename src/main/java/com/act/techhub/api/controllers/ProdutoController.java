package com.act.techhub.api.controllers;

import com.act.techhub.api.model.Produto;
import com.act.techhub.api.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Produto", tags = {"Produto Controller"}, protocols = "http")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um produto pelo ID", response = Produto.class)
    public ResponseEntity getProdutoById(
            @ApiParam(value = "ID do produto para buscar", required = true)
            @PathVariable int id) {
        Produto produto = produtoService.getProdutoByIdList(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os produtos", response = Produto.class, responseContainer = "List")
    public ResponseEntity getAllProdutos() {
        System.out.println("chamando método getAllProdutos");
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar um produto", response = String.class)
    public ResponseEntity<String> addCliente(@ApiParam(value = "Recebe um objeto do tipo Prodotu", required = true)
                                                 @RequestBody Produto produto) {
        produtoService.addProduto(produto);
        return ResponseEntity.ok("Produto adicionado com sucesso!");
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar um produto", response = String.class)
    public ResponseEntity<String> updateProduto(
            @ApiParam(value = "ID do produto para atualizar", required = true)
            @PathVariable int id, @RequestBody Produto updatedProduto) {
        if (produtoService.getProdutoById(id).isPresent()) {
            produtoService.updateProduto(id, updatedProduto);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um produto", response = String.class)
    public ResponseEntity<String> deleteProduto(
            @ApiParam(value = "ID do produto a ser removido", required = true)
            @PathVariable int id) {
        if (produtoService.getProdutoById(id).isPresent()) {
            produtoService.deleteCliente(id);
            return ResponseEntity.ok("Produto removido com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
