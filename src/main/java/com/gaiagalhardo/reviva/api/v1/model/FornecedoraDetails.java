package com.gaiagalhardo.reviva.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedoraDetails {

	private Long id;
	private String codigo;
	private String nome;
	private String apelido;
	private String dataAniversario;
	private String dataCadastro;
	private EnderecoDetails endereco;
	private String fone;
	private String email;
	private String instagram;
	private BancoSummary banco;
	private String conta;
	private String digito;
	private String agencia;
	private String tipoConta;
	private String chavePix;
	private String pix;
	
}
