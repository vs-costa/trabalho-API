package br.com.api.trabalho.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabalho.dto.PessoaAtualizarDTO;
import br.com.api.trabalho.dto.PessoaDTO;
import br.com.api.trabalho.services.PessoaService;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
//	Não consegui implementar os e-mails. deixei comentado
//	private EmailService emailService;
//    @Autowired
//    public void setEmailService(EmailService emailService) {
//        this.emailService = emailService;
//    }	
		
	@GetMapping("/buscar/{id}")
	public PessoaDTO buscarPorId(@PathVariable Integer id) {
		return pessoaService.buscarPorId(id);
	}
	
	
//	O Escopo do negócio não prevê listar todos
//	@GetMapping("/listar")
//	public List<PessoaDTO> listarTodos(){
//		return pessoaService.listarTodos();
//	}
	
	@PutMapping("/atualizar/{id}")
	public PessoaAtualizarDTO atualizar(@PathVariable Integer id, @RequestBody PessoaAtualizarDTO pessoaDTO) {
		return pessoaService.atualizar(id, pessoaDTO);
	}
	
	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
//		PessoaDTO pessoa = pessoaService.buscarPorId(id);
		pessoaService.removerLogico(id);
//		emailService.envioEmailEncerramentoConta(pessoa);
	}
	
	@PutMapping("/ativar/{id}")
	public void ativarLogico(@PathVariable Integer id) {
//		PessoaDTO pessoa = pessoaService.buscarPorId(id);
		pessoaService.ativarLogico(id);
//		emailService.envioEmailAtivacaoConta(pessoa);
	}
	
}
