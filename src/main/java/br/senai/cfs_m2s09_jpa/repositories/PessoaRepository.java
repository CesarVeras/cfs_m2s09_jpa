package br.senai.cfs_m2s09_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.senai.cfs_m2s09_jpa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "SELECT p.* FROM pessoa p WHERE status_p = TRUE", nativeQuery = true)
	List<Pessoa> getByStatus();

	// @Query(value = "SELECT p.* FROM pessoa p WHERE nome_completo LIKE %:filter% OR email %:filter%", nativeQuery = true)
	// List<Pessoa> findByNomeCompletoOrEmail(@Param("filter") String filter);

	List<Pessoa> findByNomeCompletoOrEmail(String nomeCompleto, String email);

	List<Pessoa> findByNomeCompletoContainingOrEmailContaining(String nomeCompleto, String email);
}
