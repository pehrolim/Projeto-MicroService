package com.estudo.pagamentoms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.pagamentoms.api.assembler.PagamentoAssembler;
import com.estudo.pagamentoms.api.assembler.PagamentoDisassembler;
import com.estudo.pagamentoms.api.dtos.PagamentoDtoForm;
import com.estudo.pagamentoms.api.dtos.PagamentoDtoList;
import com.estudo.pagamentoms.domain.model.Pagamento;
import com.estudo.pagamentoms.domain.repositories.PagamentoRepository;
import com.estudo.pagamentoms.domain.services.PagamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pagamentos")
public class Controller {
	
	@Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired
    private PagamentoService pagamentoService;
    
    @Autowired
    private PagamentoAssembler pagamentoAssembler;
    
    @Autowired
    private PagamentoDisassembler pagamentoDisassembler;
    
    @GetMapping
    public List<PagamentoDtoList> listar() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        
        return pagamentoAssembler.toCollectionModel(pagamentos);
    }
    
    @GetMapping("/{pagamentoId}")
    public PagamentoDtoList buscar(@PathVariable Long pagamentoId) {
        Pagamento pagamento = pagamentoService.buscarOuFalhar(pagamentoId);
        
        return pagamentoAssembler.toModel(pagamento);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDtoList salvar(@RequestBody @Valid PagamentoDtoForm pagamentoDtoForm) {
        Pagamento pagamento = pagamentoDisassembler.toEntity(pagamentoDtoForm);
        pagamento = pagamentoService.salvar(pagamento);
        
        return pagamentoAssembler.toModel(pagamento);
    }
    
    @PutMapping("/{carrinhoId}/confirmado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarStatusConfirmado(@PathVariable Long carrinhoId) {
        pagamentoService.alterarStatusConfirmado(carrinhoId);
    }

    @PutMapping("/{carrinhoId}/cancelado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarStatusCancelado(@PathVariable Long carrinhoId) {
        pagamentoService.alterarStatusCancelado(carrinhoId);
    }
	
	
}
	
	

