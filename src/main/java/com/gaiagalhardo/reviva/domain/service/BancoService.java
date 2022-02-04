package com.gaiagalhardo.reviva.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaiagalhardo.reviva.domain.exception.BancoNaoEncontradoException;
import com.gaiagalhardo.reviva.domain.exception.EntidadeEmUsoException;
import com.gaiagalhardo.reviva.domain.exception.FornecedoraEmailJaCadastradaException;
import com.gaiagalhardo.reviva.domain.model.Banco;
import com.gaiagalhardo.reviva.domain.repository.BancoRepository;

@Service
public class BancoService {

	private static final String MSG_BANCO_EM_USO = "Banco de código %d não pode ser removido. O mesmo está em uso.";

	@Autowired
	private BancoRepository bancos;

	@Transactional
	public Banco salvar(Banco banco) {

		Optional<Banco> bancoExistente = bancos.findByNome(banco.getNome());

		if (bancoExistente.isPresent() && !bancoExistente.get().equals(banco)) {
			throw new FornecedoraEmailJaCadastradaException("O Banco já possui cadastro no sistema.");
		}

		return bancos.save(banco);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			bancos.deleteById(id);
			bancos.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new BancoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_BANCO_EM_USO, id));
		}
	}

	@Transactional
	public Banco buscarOuFalhar(Long id) {
		return bancos.findById(id).orElseThrow(() -> new BancoNaoEncontradoException(id));
	}

}
