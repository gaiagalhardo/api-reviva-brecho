package com.gaiagalhardo.reviva.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaiagalhardo.reviva.api.v1.model.input.BancoInput;
import com.gaiagalhardo.reviva.domain.model.Banco;

@Component
public class BancoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Banco toDomainObject(BancoInput bancoInput) {
		return modelMapper.map(bancoInput, Banco.class);
	}

}
