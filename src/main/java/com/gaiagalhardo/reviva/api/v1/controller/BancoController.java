package com.gaiagalhardo.reviva.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reviva.domain.model.Banco;
import com.gaiagalhardo.reviva.domain.repository.BancoRepository;
import com.gaiagalhardo.reviva.domain.service.BancoService;

@RestController
@RequestMapping(path = "/api/v1/bancos", produces = MediaType.APPLICATION_JSON_VALUE)
public class BancoController {

	@Autowired
	private BancoRepository bancos;

	@Autowired
	private BancoService bancoraService;

	@GetMapping
	public List<Banco> listar() {
		return bancos.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Banco salvar(@RequestBody @Valid Banco Banco) {
		return bancoraService.salvar(Banco);
	}

}
