package com.gaiagalhardo.reviva.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaiagalhardo.reviva.api.v1.model.FornecedoraDetails;
import com.gaiagalhardo.reviva.domain.model.Fornecedora;

@Component
public class FornecedoraModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public FornecedoraDetails toModel(Fornecedora fornecedora) {
		return modelMapper.map(fornecedora, FornecedoraDetails.class);
	}
	
	public List<FornecedoraDetails> toCollectionModel(List<Fornecedora> fornecedoras){
		return fornecedoras
				.stream()
				.map(fornecedora -> toModel(fornecedora))
				.collect(Collectors.toList());
	}
	
}
