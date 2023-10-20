package br.com.api.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.entities.Admin;
import br.com.api.trabalho.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	// GET Id
	public Admin buscarPorId(Integer id) {
		return adminRepository.findById(id).get();
	}

	// GET Listar
	public List<Admin> listarTodos() {
		return adminRepository.findAll();
	}

	// POST
	public Admin salvar(Admin funcionario) {
		return adminRepository.save(funcionario);
	}

	// PUT
	public Admin atualizar(Integer id, Admin funcionario) {
		Admin registroAntigo = buscarPorId(id);

		if (funcionario.getSenha() != null) {
			registroAntigo.setSenha(funcionario.getSenha());
		}
		if (funcionario.getNome() != null) {
			registroAntigo.setNome(funcionario.getNome());
		}
		registroAntigo.setId(id);
		return adminRepository.save(registroAntigo);
	}

	public void removerLogico(Integer id) {
		Admin funcionario = buscarPorId(id);

		if (funcionario != null) {
			funcionario.setAtivo(false);
			adminRepository.save(funcionario);
		}
	}
}
