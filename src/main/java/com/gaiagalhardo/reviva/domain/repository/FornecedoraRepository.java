package com.gaiagalhardo.reviva.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaiagalhardo.reviva.domain.model.Fornecedora;

@Repository
public interface FornecedoraRepository extends JpaRepository<Fornecedora, Long>{

	Optional<Fornecedora> findByEmail(String email);
	
}
