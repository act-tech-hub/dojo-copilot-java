package com.act.techhub.api.service;

import com.act.techhub.api.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

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

    public void addCliente(Cliente cliente) {
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
}
