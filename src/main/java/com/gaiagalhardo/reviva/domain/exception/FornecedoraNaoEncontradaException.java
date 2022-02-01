package com.gaiagalhardo.reviva.domain.exception;
public class FornecedoraNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FornecedoraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public FornecedoraNaoEncontradaException(Long fornecedoraId) {
		this(String.format("Não existe uma fornecedora com código %d", fornecedoraId));
	}

}