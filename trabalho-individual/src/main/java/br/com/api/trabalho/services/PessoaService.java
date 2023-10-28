package br.com.api.trabalho.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.config.PasswordEncoder;
import br.com.api.trabalho.dto.PessoaAtualizarDTO;
import br.com.api.trabalho.dto.PessoaDTO;
import br.com.api.trabalho.entities.Endereco;
import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.entities.User;
import br.com.api.trabalho.mapper.PessoaMapper;
import br.com.api.trabalho.repositories.EnderecoRepository;
import br.com.api.trabalho.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	PessoaMapper pessoaMapper;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	// Get ID
	public PessoaDTO buscarPorId(Integer id) {
		PessoaDTO infoPessoa = new PessoaDTO();
		Pessoa pessoa = pessoaRepository.findById(id).get();
		infoPessoa = pessoaMapper.converterPessoaDTO(pessoa);
		return infoPessoa;
	}

	// Get Listar
	public List<PessoaDTO> listarTodos() {
		List<PessoaDTO> infoPessoas = new ArrayList<>();
		List<Pessoa> pessoas = pessoaRepository.findAll();
		for (Pessoa pessoa : pessoas) {
			infoPessoas.add(pessoaMapper.converterPessoaDTO(pessoa));
		}
		return infoPessoas;
	}

	// POST
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	// PUT
	public PessoaAtualizarDTO atualizar(Integer id, PessoaAtualizarDTO pessoaDTO) {
		Pessoa registroAntigo = pessoaRepository.findById(id).get();

		if (pessoaDTO.getEmail() != null) {
			User user = userService.findByEmail(registroAntigo.getEmail());
			user.setEmail(pessoaDTO.getEmail());
			registroAntigo.setEmail(pessoaDTO.getEmail());
			userService.save(user);
		}
		if (pessoaDTO.getSenha() != null) {
            User user = userService.findByEmail(registroAntigo.getEmail());
            String senhaCriptografada = PasswordEncoder.encodePassword(pessoaDTO.getSenha());
            registroAntigo.setSenha(senhaCriptografada);
            user.setSenha(senhaCriptografada);
            userService.save(user);
//            emailService.envioEmailTrocaSenha(user);
        }
		if (pessoaDTO.getCategoriaHab() != null) {
			registroAntigo.setCategoriaHab(pessoaDTO.getCategoriaHab());
		}
		if (pessoaDTO.getTelefoneFixo() != null) {
			registroAntigo.setTelefoneFixo(pessoaDTO.getTelefoneFixo());
		}
		if (pessoaDTO.getCelular() != null) {
			registroAntigo.setCelular(pessoaDTO.getCelular());
		}
		if (pessoaDTO.getCep() != null) {
			Endereco viaCep = enderecoService.pesquisarEndereco(pessoaDTO.getCep());
			Endereco enderecoNovo = new Endereco();
			enderecoNovo.setBairro(viaCep.getBairro());
			enderecoNovo.setCep(pessoaDTO.getCep());
			enderecoNovo.setComplemento(pessoaDTO.getComplementoAdicional());
			enderecoNovo.setLocalidade(viaCep.getLocalidade());
			enderecoNovo.setLogradouro(viaCep.getLogradouro());
			enderecoNovo.setNumeroResidencia(pessoaDTO.getNumeroResidencia());
			enderecoNovo.setUf(viaCep.getUf());
			enderecoRepository.save(enderecoNovo);
			registroAntigo.setEndereco(enderecoNovo);
		}
		
		PessoaAtualizarDTO pessoaConvertida = pessoaMapper.converterPessoaAtualizarDTO(registroAntigo);
		registroAntigo.setId(id);
		pessoaRepository.save(registroAntigo);
		return pessoaConvertida;
		
	}

	// Delete lógico
	public void removerLogico(Integer id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();

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
