package com.estudo.carrinhoms.domain.exception;

public class ProdutoNaoEncontradoException extends NegocioException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	 public ProdutoNaoEncontradoException(Long produtoId) {
	        this(String.format("Não foi encontrado produto de ID: %", produtoId));
	    }
}
