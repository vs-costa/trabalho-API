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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabalho.dto.CarroAtualizarDTO;
import br.com.api.trabalho.dto.CarroDTO;
import br.com.api.trabalho.entities.Carro;
import br.com.api.trabalho.services.CarroService;


@RestController
@RequestMapping("/carro")

public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@GetMapping("/buscar/{id}")
	public CarroDTO buscarPorId(@PathVariable Integer id) {
		return carroService.buscarPorId(id);
	}
	
	@GetMapping("/listar")
	public List<CarroDTO> listarTodos(){
		return carroService.listarTodos();
	}

	@PostMapping("/salvar")
	public Carro salvar(@RequestBody CarroDTO carroDTO, @RequestParam String nomePessoa) {
		return carroService.salvar(carroDTO, nomePessoa);
	}
	
	@PutMapping("/atualizar/{id}")
	public CarroAtualizarDTO atualizar(@PathVariable Integer id, @RequestBody CarroAtualizarDTO carro) {
		return carroService.atualizar(id, carro);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		carroService.removerLogico(id);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
		CarroDTO carroDTO = carroService.buscarPorId(id);
		carroService.ativarLogico(id);
//		emailService.envioEmailAtivacaoConta(carro);
	}

}
