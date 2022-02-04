package com.gaiagalhardo.reviva.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaiagalhardo.reviva.api.v1.model.input.FornecedoraInput;
import com.gaiagalhardo.reviva.domain.model.Fornecedora;

@Component
public class FornecedoraInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Fornecedora toDomainObject(FornecedoraInput fornecedoraInput) {
		return modelMapper.map(fornecedoraInput, Fornecedora.class);
	}

}
