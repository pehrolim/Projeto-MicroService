package com.estudo.carrinhoms.api.dtos;

import com.estudo.carrinhoms.domain.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoDtoList {
	
    private Long id;
    private Status status;
    private ProdutoDtoList produto;
	
}
