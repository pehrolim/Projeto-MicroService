package com.estudo.carrinhoms.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.carrinhoms.domain.Repository.CarrinhoRepository;
import com.estudo.carrinhoms.domain.exception.CarrinhoNaoEncontradoException;
import com.estudo.carrinhoms.domain.external.PagamentoClient;
import com.estudo.carrinhoms.domain.model.Carrinho;

import jakarta.transaction.Transactional;

@Service
public class CarrinhoService {
	@Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private PagamentoClient pagamentoClient;
    
    @Transactional
    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }
    
    @Transactional
    public void alterarStatusConfirmado(Long carrinhoId) {
        Carrinho carrinho = this.buscarOuFalhar(carrinhoId);
        carrinho.alterarStatusConfirmado();
        pagamentoClient.alterarStatusPagamentoConfirmado(carrinhoId);
    }

    @Transactional
    public void alterarStatusCancelado(Long carrinhoId) {
        Carrinho carrinho = this.buscarOuFalhar(carrinhoId);
        carrinho.alterarStatusCancelado();
        pagamentoClient.alterarStatusPagamentoCancelado(carrinhoId);
    }
    
    public Carrinho buscarOuFalhar(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new CarrinhoNaoEncontradoException(carrinhoId));
    }
}
