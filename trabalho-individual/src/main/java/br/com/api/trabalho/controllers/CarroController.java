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

import br.com.api.trabalho.entities.Carro;
import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.services.CarroService;


@RestController
@RequestMapping("/carro")

public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@GetMapping("/buscar/{id}")
	public Carro buscarPorId(@PathVariable Integer id) {
		return carroService.buscarPorId(id);
	}
	
	@GetMapping("/listar")
	public List<Carro> listarTodos(){
		return carroService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public Carro salvar(@RequestBody Carro carro) {
		return carroService.salvar(carro);
	}
	
	@PutMapping("/atualizar/{id}")
	public Carro atualizar(@PathVariable Integer id, @RequestBody Carro carro) {
		return carroService.atualizar(id, carro);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		carroService.removerLogico(id);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
		Carro carro = carroService.buscarPorId(id);
		carroService.ativarLogico(id);
//		emailService.envioEmailAtivacaoConta(carro);
	}

}
