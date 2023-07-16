package com.estudo.carrinhoms.domain.exception;

public class CarrinhoNaoEncontradoException extends NegocioException{
	 
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CarrinhoNaoEncontradoException(String mensagem) {
		 super(mensagem);
		}
	  public CarrinhoNaoEncontradoException(Long carrinhoId) {
	        this(String.format("Carrinho de ID: %d, não foi encontrado", carrinhoId));
	    }
}
