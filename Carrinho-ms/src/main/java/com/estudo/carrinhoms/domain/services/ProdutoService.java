package com.estudo.carrinhoms.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.carrinhoms.domain.Repository.ProdutoRepository;
import com.estudo.carrinhoms.domain.exception.ProdutoNaoEncontradoException;
import com.estudo.carrinhoms.domain.model.Produto;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	   @Autowired
	    private ProdutoRepository produtoRepository;
	    
	    @Transactional
	    public Produto salvar(Produto produto) {
	        return produtoRepository.save(produto);
	    }
	    
	    @Transactional
	    public void remover(Long produtoId) {
	        Produto  produto = this.buscarOuFalhar(produtoId);
	        
	        produtoRepository.delete(produto);
	    }
	    
	    public Produto buscarOuFalhar(Long produtoId) {
	        return produtoRepository.findById(produtoId)
	                .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
	    }
}
