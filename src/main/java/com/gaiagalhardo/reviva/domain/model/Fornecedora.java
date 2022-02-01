package com.gaiagalhardo.reviva.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Fornecedora {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String codigo;
	private String nome;
	private String apelido;
	
	@Column(name = "data_aniversario")
	private OffsetDateTime dataAniversario;
	
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;

	@Embedded
	private Endereco endereco;

	private String email;
	private String instagram;

	@Embedded
	private DadosBancarios dadosBancarios;

}
