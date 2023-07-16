package com.estudo.carrinhoms.api.dtos;

import com.estudo.carrinhoms.domain.model.Status;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoDtoForm {
	
    
    private Status status = Status.CRIADO;

    @NotNull
    private ProdutoDtoId produtoId;
	
}
