package br.com.api.trabalho.controllers;

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

//	Não consegui implementar os e-mails. deixei comentado
//	private EmailService emailService;
//    @Autowired
//    public void setEmailService(EmailService emailService) {
//        this.emailService = emailService;
//    }
	
	@GetMapping("/buscar/{id}")
	public CarroDTO buscarPorId(@PathVariable Integer id) {
		return carroService.buscarPorId(id);
	}
	
	@PostMapping("/salvar")
	public Carro salvar(@RequestBody CarroDTO carroDTO, @RequestParam String emailPessoa) {
		return carroService.salvar(carroDTO, emailPessoa);
//		emailService.envioEmailCadastroCarro(carroDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public CarroAtualizarDTO atualizar(@PathVariable Integer id, @RequestBody CarroAtualizarDTO carro) {
		return carroService.atualizar(id, carro);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
//		CarroDTO carro = carroService.buscarPorId(id);
		carroService.removerLogico(id);
//		emailService.envioEmailEncerramentoCarro(carro);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
//		CarroDTO carroDTO = carroService.buscarPorId(id);
		carroService.ativarLogico(id);
//		emailService.envioEmailAtivacaoCarro(carroDTO);
	}

}
