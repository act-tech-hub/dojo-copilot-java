package com.act.techhub.api.service;

import com.act.techhub.api.controllers.request.ClienteRequest;
import com.act.techhub.api.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public ClienteService() {
        clientes.add(new Cliente(1, "Enzo Cauã Geraldo Carvalho", "Travessa Dois, 679", "(53) 98380-6668", "enzo_caua_carvalho@accardoso.com.br"));
        clientes.add(new Cliente(2, "Aurora Alice Novaes", "Rua Riachuelo, 735", "(91) 99128-7182", "aurora.alice.novaes@performa.com.br"));
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente getClienteByIdList(int id) {
        return clientes.get(id);
    }

    public void addCliente(ClienteRequest request) {
        //refatorar este método

        int newId = idCounter.incrementAndGet();
        Cliente cliente = new Cliente();
        cliente.setId(newId);
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(request.getEndereco());
        cliente.setTelefone(request.getTelefone());
        clientes.add(cliente);

    }

    public Optional<Cliente> getClienteById(int id) {
        return clientes.stream().filter(cliente -> cliente.getId() == id).findFirst();
    }

    public void updateCliente(int id, Cliente updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, updatedCliente);
                return;
            }
        }
    }

    public void deleteCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Compare this snippet from src/main/java/com/act/techhub/api/service/ProdutoService.java:
    // package com.act.techhub.api.service

    // import com.act.techhub.api.model.Produto;
    // import org.springframework.stereotype.Service;

    // import java.math.BigDecimal;

    // import java.util.ArrayList;
    // import java.util.List;
    // import java.util.Optional;
    // import java.util.concurrent.atomic.AtomicInteger;

    // @Service
    // public class ProdutoService {

    //     private List<Produto> produtos = new ArrayList<>();
    //     private AtomicInteger idCounter = new AtomicInteger();

    //     public ProdutoService() {
    //         produtos.add(new Produto(1, "Cadeira Gamer", new BigDecimal("1200.00"), 10));
    //         produtos.add(new Produto(2, "Mesa Gamer", new BigDecimal("1500.00"), 5));
    //     }

    //     public List<Produto> getAllProdutos() {
    //         return produtos;
    //     }

    //     public Produto getProdutoByIdList(int id) {
    //         return produtos.get(id);
    //     }

    //     public void addProduto(Produto produto) {
    //         int newId = idCounter.incrementAndGet();
    //         produto.setId(newId);
    //         produtos.add(produto);
    //     }

    //     public Optional<Produto> getProdutoById(int id) {
    //         return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    //     }



    //     public void deleteProduto(int id) {
    //         produtos.removeIf(produto -> produto.getId() == id);
    //     }
    //

}
