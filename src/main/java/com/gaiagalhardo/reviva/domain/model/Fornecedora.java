package com.gaiagalhardo.reviva.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

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
	
	private String codigo = gerarCodigo();
	private String nome;
	private String apelido;
	
	@Column(name = "data_aniversario")
	private OffsetDateTime dataAniversario;
	
	@CreationTimestamp
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;

	@Embedded
	private Endereco endereco;

	private String fone;
	private String email;
	private String instagram;

	@ManyToOne
	@JoinColumn(name = "id_banco")
	private Banco banco;
	
	private String conta;

	private String digito;

	private String agencia;

	@Column(name = "tipo_conta")
	private String tipoConta;
	
	@Column(name = "chave_pix")
	private String chavePix;

	private String pix;

	
	private String gerarCodigo() {
		String result = UUID.randomUUID().toString();
		String codigoPersonalizado = "R" + result.replaceAll("[^a-zA-Z]","").toUpperCase().substring(0, 4);
		return codigoPersonalizado;
	}
	
}
