package com.gaiagalhardo.reviva.domain.model;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Embeddable
public class Endereco {

	private String estado;

	private String cidade;

	private String logradouro;

	private String bairro;
	private String cep;
	private String complemento;

}
