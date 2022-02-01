package com.gaiagalhardo.reviva.domain.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private String complemento;
	
}
