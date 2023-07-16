package com.estudo.pagamentoms.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.pagamentoms.domain.model.Pagamento;
import com.estudo.pagamentoms.domain.repositories.PagamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class PagamentoService {
	
	@Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Transactional
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    
    @Transactional
    public void alterarStatusConfirmado(Long carrinhoId) {
        Pagamento pagamento = this.buscarPagamentoCarrinho(carrinhoId);
        pagamento.alterarStatusConfirmado();
    }

    @Transactional
    public void alterarStatusCancelado(Long carrinhoId) {
        Pagamento carrinho = this.buscarPagamentoCarrinho(carrinhoId);
        carrinho.alterarStatusCancelado();
    }
    
    public Pagamento buscarOuFalhar(Long pagamentoId) {
        return pagamentoRepository.getReferenceById(pagamentoId);
    }
    
    private Pagamento buscarPagamentoCarrinho(Long carrinhoId) {
        return pagamentoRepository.getReferenceById(carrinhoId);
    }
	
}
