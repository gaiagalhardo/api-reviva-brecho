package com.gaiagalhardo.reviva.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DadosBancarios {

	private String banco;

	@Column(name = "numero_conta")
	private String numeroConta;

	@Column(name = "digito_conta")
	private String DigitoConta;

	private String agencia;

	@Column(name = "tipo_conta")
	private String tipoConta;

	@Column(name = "chave_pix")
	private String chavePix;

	private String pix;

}
