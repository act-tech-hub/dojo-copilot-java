package com.act.techhub.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private int id;

    private String nome;

    private String endereco;

    private String telefone;

    private String email;
}
