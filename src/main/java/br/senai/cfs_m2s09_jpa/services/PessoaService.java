package br.senai.cfs_m2s09_jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.cfs_m2s09_jpa.entities.Pessoa;
import br.senai.cfs_m2s09_jpa.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> getAll() {
		return this.pessoaRepository.findAll();
	}

	public Pessoa getById(Long id) {
		Optional<Pessoa> opPessoa = this.pessoaRepository.findById(id);
		if (opPessoa.isPresent()) {
			return opPessoa.get();
		}
		return null;
	}

	public List<Pessoa> getStatusActive() {
		return this.pessoaRepository.getByStatus();
	}

	public List<Pessoa> getByNameOrEmail(String filtro) {
		return this.pessoaRepository.findByNomeCompletoContainingOrEmailContaining(filtro, filtro);
	}

	public void save(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}

	public void update(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}

	public void delete(Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
