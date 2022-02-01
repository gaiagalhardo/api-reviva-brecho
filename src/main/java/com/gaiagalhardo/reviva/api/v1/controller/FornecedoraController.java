package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reviva.domain.model.Fornecedora;
import com.gaiagalhardo.reviva.domain.repository.FornecedoraRepository;

@RestController
@RequestMapping(path = "/api/v1/fornecedoras")
public class FornecedoraController {

	@Autowired
	private FornecedoraRepository fornecedoras;
	
	@GetMapping
	private List<Fornecedora> listar(){
		return fornecedoras.findAll();
	}
	
}
