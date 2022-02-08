package com.gaiagalhardo.reviva.api.exceptionhandler;
import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"), 
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de Sistema"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem Incompreensível"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	TAMANHO_MAXIMO_UPLOAD("/tamanho-maximo", "Tamanho máximo de upload excedido"),
	ACESSO_NEGADO("/acesso-negado", "Acesso negado");

	private String title;
	private String uri;

	private ProblemType(String path, String title) {
		this.uri = "http://reviva.com.br" + path;
		this.title = title;

	}

}