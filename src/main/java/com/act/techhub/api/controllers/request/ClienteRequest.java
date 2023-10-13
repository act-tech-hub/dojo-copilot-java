package com.act.techhub.api.controllers.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private String nome;

    private String endereco;

    private String telefone;

    private String email;
}
