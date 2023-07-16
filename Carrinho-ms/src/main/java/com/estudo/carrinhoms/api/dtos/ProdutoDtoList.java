package com.estudo.carrinhoms.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDtoList {
    private Long id;
    private String nome;
    private Long qtde;
    private String descricao;
}
