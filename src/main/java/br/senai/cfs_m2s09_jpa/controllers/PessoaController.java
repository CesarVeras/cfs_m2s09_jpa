package br.senai.cfs_m2s09_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senai.cfs_m2s09_jpa.entities.Pessoa;
import br.senai.cfs_m2s09_jpa.services.PessoaService;
import jdk.jshell.Snippet.Status;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> buscarTodos() {
		return this.pessoaService.getAll();
	}

	@GetMapping("/{id}")
	public Pessoa buscarPorId(@PathVariable Long id) {
		return this.pessoaService.getById(id);
	}

	@GetMapping("/statusAtivo")
	public List<Pessoa> buscarPorStatusAtivo() {
		return this.pessoaService.getStatusActive();
	}

	@GetMapping("/nomeOuEmail")
	public List<Pessoa> buscarPorNomeOuEmail(@RequestParam(required = false) String filtro) {
		return this.pessoaService.getByNameOrEmail(filtro);
	}

	@PostMapping
	public void salvar(@RequestBody Pessoa pessoa) {
		this.pessoaService.save(pessoa);
	}

	@PutMapping
	public void atualizar(@RequestBody Pessoa pessoa) {
		this.pessoaService.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.pessoaService.delete(id);
	}
}
