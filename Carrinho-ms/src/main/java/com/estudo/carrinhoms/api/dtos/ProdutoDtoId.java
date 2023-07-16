package com.estudo.carrinhoms.api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDtoId {
	
	public ProdutoDtoId(Long id) {
	    this.id = id;
	}
	
    @NotNull
    private Long id;
}
