package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reviva.api.v1.assembler.BancoInputDisassembler;
import com.gaiagalhardo.reviva.api.v1.assembler.BancoModelAssembler;
import com.gaiagalhardo.reviva.api.v1.model.BancoSummary;
import com.gaiagalhardo.reviva.api.v1.model.input.BancoInput;
import com.gaiagalhardo.reviva.domain.exception.BancoNaoEncontradoException;
import com.gaiagalhardo.reviva.domain.exception.NegocioException;
import com.gaiagalhardo.reviva.domain.model.Banco;
import com.gaiagalhardo.reviva.domain.repository.BancoRepository;
import com.gaiagalhardo.reviva.domain.service.BancoService;

@RestController
@RequestMapping(path = "/api/v1/bancos", produces = MediaType.APPLICATION_JSON_VALUE)
public class BancoController {

	@Autowired
	private BancoRepository bancos;

	@Autowired
	private BancoService bancoService;

	@Autowired
	private BancoModelAssembler bancoModelAssembler;

	@Autowired
	private BancoInputDisassembler bancoInputDisassembler;

	@GetMapping
	public List<BancoSummary> listar() {
		return bancoModelAssembler.toCollectionModel(bancos.findAll());
	}
	
	@GetMapping("/{id}")
	public BancoSummary buscar(@PathVariable Long id) {
		
		Banco banco = bancoService.buscarOuFalhar(id);
		
		return bancoModelAssembler.toModel(banco);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public BancoSummary salvar(@RequestBody @Valid BancoInput bancoInput) {
		try {
			Banco banco = bancoInputDisassembler.toDomainObject(bancoInput);

			return bancoModelAssembler.toModel(bancoService.salvar(banco));

		} catch (BancoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		bancoService.excluir(id);
	}

}
