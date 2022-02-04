package com.gaiagalhardo.reviva.api.v1.model;

import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "bancos")
@Getter
@Setter
public class BancoSummary {

	private Long id;
	private String nome;
	
}
