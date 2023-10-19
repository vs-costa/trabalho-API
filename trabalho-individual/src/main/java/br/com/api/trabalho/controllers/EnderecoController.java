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

import br.com.api.trabalho.dto.EnderecoDTO;
import br.com.api.trabalho.entities.Endereco;
import br.com.api.trabalho.services.EnderecoService;



@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping("/buscar/{id}")
	public Endereco buscarPorId(@PathVariable Integer id) {
		return enderecoService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<Endereco> listarTodos() {
		return enderecoService.listarTodos();
	}
	
	@PostMapping("/salvar")
	public Endereco salvar(@RequestBody EnderecoDTO endereco) {
		return enderecoService.salvar(endereco);

	}
	
	@PutMapping("/atualizar/{id}")
	public Endereco atualizar(@PathVariable Integer id, @RequestBody Endereco endereco) {
		return enderecoService.atualizar(id, endereco);
	}
	
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Integer id) {
		enderecoService.remover(id);
	}
}

