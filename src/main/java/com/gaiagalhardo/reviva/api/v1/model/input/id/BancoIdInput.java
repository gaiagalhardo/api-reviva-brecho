package com.gaiagalhardo.reviva.api.v1.model.input.id;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoIdInput {

	@NotNull
	private Long id;
	
}
