package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reviva.domain.model.Fornecedora;
import com.gaiagalhardo.reviva.domain.repository.FornecedoraRepository;
import com.gaiagalhardo.reviva.domain.service.FornecedoraService;

@RestController
@RequestMapping(path = "/api/v1/fornecedoras")
public class FornecedoraController {

	@Autowired
	private FornecedoraRepository fornecedoras;
	
	@Autowired
	private FornecedoraService fornecedoraService;
	
	@GetMapping
	public List<Fornecedora> listar(){
		return fornecedoras.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Fornecedora salvar(@RequestBody @Valid Fornecedora fornecedora) {
		return fornecedoraService.salvar(fornecedora);
	}

	
}
