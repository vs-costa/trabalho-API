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

import br.com.api.trabalho.entities.Admin;
import br.com.api.trabalho.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/buscar/{id}")
	public Admin buscarPorId(@PathVariable Integer id) {
		return adminService.buscarPorId(id);
	}

	@GetMapping("/listar")
	public List<Admin> listarTodos() {
		return adminService.listarTodos();
	}

	@PostMapping("/salvar")
	public Admin salvar(@RequestBody Admin funcionario) {
		return adminService.salvar(funcionario);

	}

	@PutMapping("/atualizar/{id}")
	public Admin atualizar(@PathVariable Integer id, @RequestBody Admin funcionario) {
		return adminService.atualizar(id, funcionario);
	}

	@DeleteMapping("/remover/{id}")
	public void removerLogico(@PathVariable Integer id) {
		adminService.removerLogico(id);
	}
}
