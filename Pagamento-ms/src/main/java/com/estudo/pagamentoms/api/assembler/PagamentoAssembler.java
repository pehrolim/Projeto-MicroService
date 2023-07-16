package com.estudo.pagamentoms.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudo.pagamentoms.api.dtos.PagamentoDtoList;
import com.estudo.pagamentoms.domain.model.Pagamento;

@Component
public class PagamentoAssembler {
	

    @Autowired
    private ModelMapper modelMapper;
    
    public PagamentoDtoList toModel(Pagamento pagamento) {
        return modelMapper.map(pagamento, PagamentoDtoList.class);
    }
    
    public List<PagamentoDtoList> toCollectionModel(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(pagamento -> toModel(pagamento))
                .collect(Collectors.toList());
    }
    
	
	
}
