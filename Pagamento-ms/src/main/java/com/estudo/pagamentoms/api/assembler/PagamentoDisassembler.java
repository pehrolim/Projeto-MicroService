package com.estudo.pagamentoms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudo.pagamentoms.api.dtos.PagamentoDtoForm;
import com.estudo.pagamentoms.domain.model.Pagamento;

@Component
public class PagamentoDisassembler {
	

    @Autowired
    private ModelMapper modelMapper;
    
    public Pagamento toEntity(PagamentoDtoForm pagamentoDtoForm) {
        return modelMapper.map(pagamentoDtoForm, Pagamento.class);
    }
	
}
