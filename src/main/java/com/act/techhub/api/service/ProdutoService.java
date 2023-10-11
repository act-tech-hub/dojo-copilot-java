package com.act.techhub.api.service;

import com.act.techhub.api.model.Produto;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    //private NumberFormat numberFormat = new NumberFormat(Locale.US.getCountry());

    public ProdutoService() {
        produtos.add(new Produto(1, "Camiseta Thor", new BigDecimal(59.90).setScale(2, BigDecimal.ROUND_CEILING), 125));
        produtos.add(new Produto(2, "Camiseta Maranha", new BigDecimal(49.90).setScale(2, BigDecimal.ROUND_CEILING), 200));
    }

    public List<Produto> getAllProdutos() {
        return produtos;
    }

    public Produto getProdutoByIdList(int id) {
        return produtos.get(id);
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public Optional<Produto> getProdutoById(int id) {
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    public void updateProduto(int id, Produto updatedProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.set(i, updatedProduto);
                return;
            }
        }
    }

    public void deleteCliente(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

}
