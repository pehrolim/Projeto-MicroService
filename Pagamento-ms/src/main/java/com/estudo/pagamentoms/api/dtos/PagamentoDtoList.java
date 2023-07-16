package com.estudo.pagamentoms.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.estudo.pagamentoms.domain.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDtoList {
	

    private Long id;    
    private BigDecimal valor;    
    private String nome;    
    private String numeroCartao;    
    private LocalDate expiracaoCartao;    
    private String codigo;    
    private Status status;    
    private Long carrinhoId;
	
}
