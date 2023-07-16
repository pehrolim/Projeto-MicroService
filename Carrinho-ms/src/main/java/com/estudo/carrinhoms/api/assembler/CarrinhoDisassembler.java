package com.estudo.carrinhoms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudo.carrinhoms.api.dtos.CarrinhoDtoForm;
import com.estudo.carrinhoms.domain.model.Carrinho;

@Component
public class CarrinhoDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Carrinho toEntity(CarrinhoDtoForm carrinhoDtoForm) {
        return modelMapper.map(carrinhoDtoForm, Carrinho.class);
    }
}
