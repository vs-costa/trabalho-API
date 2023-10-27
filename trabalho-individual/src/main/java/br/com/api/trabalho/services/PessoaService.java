package br.com.api.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	// Get ID
	public Pessoa buscarPorId(Integer id) {
		return pessoaRepository.findById(id).get();
	}

	// Get Listar
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

	// POST
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	// PUT
	public Pessoa atualizar(Integer id, Pessoa pessoa) {
		Pessoa registro = buscarPorId(id);

		if (pessoa.getCpf() != null) {
			registro.setCpf(pessoa.getCpf());
		}
		if (pessoa.getNome() != null) {
			registro.setNome(pessoa.getNome());
		}
		if (pessoa.getDataNascimento() != null) {
			registro.setDataNascimento(pessoa.getDataNascimento());
		}
		if (pessoa.getNumeroCnh() != null) {
			registro.setNumeroCnh(pessoa.getNumeroCnh());
		}
		if (pessoa.getCategoriaHab() != null) {
			registro.setCategoriaHab(pessoa.getCategoriaHab());
		}
		if (pessoa.getTelefoneFixo() != null) {
			registro.setTelefoneFixo(pessoa.getTelefoneFixo());
		}
		if (pessoa.getCelular() != null) {
			registro.setCelular(pessoa.getCelular());
		}
		registro.setId(id);
		return pessoaRepository.save(registro);
	}

	// Delete lógico
	public void removerLogico(Integer id) {
		Pessoa pessoa = buscarPorId(id);

		if (pessoa != null) {
			pessoa.setAtivo(false);
			pessoaRepository.save(pessoa);

		}
	}

	// Ativar Lógico
	public void ativarLogico(Integer id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();

		if (pessoa != null) {
			pessoa.setAtivo(true);
			pessoaRepository.save(pessoa);
		}
	}
}
