package com.gaiagalhardo.reviva.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaiagalhardo.reviva.domain.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {

	Optional<Banco> findByNome(String nome);

}
