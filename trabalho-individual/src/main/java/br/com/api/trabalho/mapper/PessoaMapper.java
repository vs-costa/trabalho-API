package br.com.api.trabalho.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.trabalho.dto.PessoaAtualizarDTO;
import br.com.api.trabalho.dto.PessoaDTO;
import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.services.PessoaService;

@Component
public class PessoaMapper {

	@Autowired
	PessoaService pessoaService;

	// Converter DTO
	public PessoaDTO converterPessoaDTO(Pessoa pessoa) {
		PessoaDTO pessoaConvertida = new PessoaDTO();
		pessoaConvertida.setCpf(pessoa.getCpf());
		pessoaConvertida.setEmail(pessoa.getEmail());
		pessoaConvertida.setNome(pessoa.getNome());
		pessoaConvertida.setDataNascimento(pessoa.getDataNascimento());
		pessoaConvertida.setNumeroCnh(pessoa.getNumeroCnh());
		pessoaConvertida.setCategoriaHab(pessoa.getCategoriaHab());
		pessoaConvertida.setTelefoneFixo(pessoa.getTelefoneFixo());
		pessoaConvertida.setCelular(pessoa.getCelular());
		pessoaConvertida.setCep(pessoa.getEndereco().getCep());
		pessoaConvertida.setNumeroResidencia(pessoa.getEndereco().getNumeroResidencia());
		pessoaConvertida.setComplementoAdicional(pessoa.getEndereco().getComplemento());
		return pessoaConvertida;
	}

	// Atualizar DTO
	public PessoaAtualizarDTO converterPessoaAtualizarDTO(Pessoa pessoa) {
		PessoaAtualizarDTO pessoaConvertida = new PessoaAtualizarDTO();
		pessoaConvertida.setEmail(pessoa.getEmail());
		pessoaConvertida.setCategoriaHab(pessoa.getCategoriaHab());
		pessoaConvertida.setTelefoneFixo(pessoa.getTelefoneFixo());
		pessoaConvertida.setCelular(pessoa.getCelular());
		pessoaConvertida.setCep(pessoa.getEndereco().getCep());
		pessoaConvertida.setNumeroResidencia(pessoa.getEndereco().getNumeroResidencia());
		pessoaConvertida.setComplementoAdicional(pessoa.getEndereco().getComplemento());
		return pessoaConvertida;
	}

}
