package com.gaiagalhardo.reviva.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaiagalhardo.reviva.domain.exception.FornecedoraNaoEncontradaException;
import com.gaiagalhardo.reviva.domain.model.Fornecedora;
import com.gaiagalhardo.reviva.domain.repository.FornecedoraRepository;

@Service
public class FornecedoraService {

	@Autowired
	private FornecedoraRepository fornecedoras;
	
	@Transactional
	public Fornecedora salvar(Fornecedora fornecedora) {
		return fornecedoras.save(fornecedora);
	}
	
	@Transactional
	public Fornecedora buscarOuFalhar(Long id) {
		return fornecedoras.findById(id).orElseThrow(() -> new FornecedoraNaoEncontradaException(id));
	}
	
}
