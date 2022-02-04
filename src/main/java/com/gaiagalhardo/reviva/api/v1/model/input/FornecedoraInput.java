package com.gaiagalhardo.reviva.api.v1.model.input;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import com.gaiagalhardo.reviva.api.v1.model.input.id.BancoIdInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedoraInput {

	@NotBlank
	private String nome;

	private String apelido;
	private OffsetDateTime dataAniversario;
	private EnderecoInput endereco;
	private String fone;
	private String email;
	private String instagram;
	private BancoIdInput banco;
	private String conta;
	private String digito;
	private String agencia;
	private String tipoConta;
	private String chavePix;
	private String pix;

}
