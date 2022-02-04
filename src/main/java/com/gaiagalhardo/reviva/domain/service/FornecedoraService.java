package com.gaiagalhardo.reviva.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaiagalhardo.reviva.domain.exception.EntidadeEmUsoException;
import com.gaiagalhardo.reviva.domain.exception.FornecedoraEmailJaCadastradaException;
import com.gaiagalhardo.reviva.domain.exception.FornecedoraNaoEncontradaException;
import com.gaiagalhardo.reviva.domain.model.Fornecedora;
import com.gaiagalhardo.reviva.domain.repository.FornecedoraRepository;

@Service
public class FornecedoraService {

	private static final String MSG_FORNECEDORA_EM_USO = "Fornecedora de código %d não pode ser removida. A mesma está em uso.";

	@Autowired
	private FornecedoraRepository fornecedoras;

	@Transactional
	public Fornecedora salvar(Fornecedora fornecedora) {
		
		Optional<Fornecedora> fornecedoraExistente = fornecedoras.findByEmail(fornecedora.getEmail());
		
		if (fornecedoraExistente.isPresent() && !fornecedoraExistente.get().equals(fornecedora)) {
			throw new FornecedoraEmailJaCadastradaException("A fornecedora já possui cadastro no sistema.");
		}
		
		return fornecedoras.save(fornecedora);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			fornecedoras.deleteById(id);
			fornecedoras.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new FornecedoraNaoEncontradaException(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_FORNECEDORA_EM_USO, id));
		}
	}

	@Transactional
	public Fornecedora buscarOuFalhar(Long id) {
		return fornecedoras.findById(id).orElseThrow(() -> new FornecedoraNaoEncontradaException(id));
	}

}
