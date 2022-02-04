package com.gaiagalhardo.reviva.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDetails {

	private String estado;
	private String cidade;
	private String logradouro;
	private String bairro;
	private String cep;
	private String complemento;

}
