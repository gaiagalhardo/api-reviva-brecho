package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reviva.api.v1.assembler.FornecedoraInputDisassembler;
import com.gaiagalhardo.reviva.api.v1.assembler.FornecedoraModelAssembler;
import com.gaiagalhardo.reviva.api.v1.assembler.FornecedoraResumoModelAssembler;
import com.gaiagalhardo.reviva.api.v1.model.FornecedoraDetails;
import com.gaiagalhardo.reviva.api.v1.model.FornecedoraSummary;
import com.gaiagalhardo.reviva.api.v1.model.input.FornecedoraInput;
import com.gaiagalhardo.reviva.domain.exception.FornecedoraNaoEncontradaException;
import com.gaiagalhardo.reviva.domain.exception.NegocioException;
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

	@Autowired
	private FornecedoraResumoModelAssembler fornecedoraResumoModelAssembler;

	@Autowired
	private FornecedoraModelAssembler fornecedoraModelAssembler;

	@Autowired
	private FornecedoraInputDisassembler fornecedoraInputDisassembler;

	@GetMapping
	public List<FornecedoraSummary> listar() {
		return fornecedoraResumoModelAssembler.toCollectionModel(fornecedoras.findAll());
	}

	@GetMapping("/{id}")
	public FornecedoraDetails buscar(@PathVariable Long id) {

		Fornecedora fornecedora = fornecedoraService.buscarOuFalhar(id);

		return fornecedoraModelAssembler.toModel(fornecedora);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public FornecedoraSummary salvar(@RequestBody @Valid FornecedoraInput fornecedoraInput) {
		try {
			Fornecedora fornecedora = fornecedoraInputDisassembler.toDomainObject(fornecedoraInput);

			return fornecedoraResumoModelAssembler.toModel(fornecedoraService.salvar(fornecedora));
		} catch (FornecedoraNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		fornecedoraService.excluir(id);
	}
	

}
