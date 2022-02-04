package com.gaiagalhardo.reviva.domain.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Embeddable
public class Endereco {

	private String pais;
	private String estado;
	
	@NotBlank
	private String cidade;
	
	private String bairro;
	private String cep;
	private String complemento;
	
}
