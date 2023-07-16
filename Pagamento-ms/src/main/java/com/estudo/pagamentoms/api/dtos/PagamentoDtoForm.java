package com.estudo.pagamentoms.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.estudo.pagamentoms.domain.model.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Data
public class PagamentoDtoForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Positive
    private BigDecimal valor;
	@NotBlank
    private String nome;
	@NotBlank
    private String numeroCartao;
    private LocalDate expiracaoCartao;
    @NotBlank
    private String codigo;
    private Status status = Status.CRIADO;
    @Positive
    private Long carrinhoId;
	

}
