package com.estudo.carrinhoms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudo.carrinhoms.api.dtos.ProdutoDtoForm;
import com.estudo.carrinhoms.domain.model.Produto;

@Component
public class ProdutoDisassembler {
	
    @Autowired
    private ModelMapper modelMapper;
    
    public Produto toEntity(ProdutoDtoForm produtoDtoForm) {
        return modelMapper.map(produtoDtoForm, Produto.class);
    }
    
    public void toModelEntity(ProdutoDtoForm produtoForm, Produto produto) {
        modelMapper.map(produtoForm, produto);
    }
	
}
