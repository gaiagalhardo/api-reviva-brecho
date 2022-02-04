package com.gaiagalhardo.reviva.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaiagalhardo.reviva.api.v1.model.BancoSummary;
import com.gaiagalhardo.reviva.domain.model.Banco;

@Component
public class BancoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public BancoSummary toModel(Banco banco) {
		return modelMapper.map(banco, BancoSummary.class);
	}
	
	public List<BancoSummary> toCollectionModel(List<Banco> bancos){
		return bancos
				.stream()
				.map(banco -> toModel(banco))
				.collect(Collectors.toList());
	}
	
}
