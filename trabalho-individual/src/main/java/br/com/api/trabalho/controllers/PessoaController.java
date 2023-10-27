package br.com.api.trabalho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.services.PessoaService;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/buscar/{id}")
	public Pessoa buscarPorId(@PathVariable Integer id) {
		return pessoaService.buscarPorId(id);
	}
	
	@GetMapping("/listar")
	public List<Pessoa> listarTodos(){
		return pessoaService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public Pessoa salvar(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}
	
	@PutMapping("/atualizar/{id}")
	public Pessoa atualizar(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		return pessoaService.atualizar(id, pessoa);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		pessoaService.removerLogico(id);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		pessoaService.ativarLogico(id);
//		emailService.envioEmailAtivacaoConta(pessoa);
	}
	
}
