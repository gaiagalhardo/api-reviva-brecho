package com.gaiagalhardo.reviva.domain.exception;
public class BancoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public BancoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public BancoNaoEncontradoException(Long fornecedoraId) {
		this(String.format("Não existe uma fornecedora com código %d", fornecedoraId));
	}

}