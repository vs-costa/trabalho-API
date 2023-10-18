package br.com.api.trabalho.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.trabalho.dto.EnderecoDto;
import br.com.api.trabalho.entities.Endereco;
import br.com.api.trabalho.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	//GET Id
		public Endereco buscarPorId(Integer id) {
			return enderecoRepository.findById(id).get();
		}

		//GET Listar
		public List<Endereco> listarTodos() {
			return enderecoRepository.findAll();
		}

		//POST
		public Endereco salvar(EnderecoDto endereco) {
			
			Endereco viaCep = pesquisarEndereco(endereco.getCep());
			Endereco enderecoNovo = new Endereco();
			enderecoNovo.setBairro(viaCep.getBairro());
			enderecoNovo.setCep(endereco.getCep());
			enderecoNovo.setComplemento(endereco.getComplemento());
			enderecoNovo.setLocalidade(viaCep.getLocalidade());
			enderecoNovo.setLogradouro(viaCep.getLogradouro());
			enderecoNovo.setNumero(endereco.getNumero());
			enderecoNovo.setUf(viaCep.getUf());
			return enderecoRepository.save(enderecoNovo);
		}

		//PUT
		public Endereco atualizar(Integer id, Endereco endereco) {
			Endereco registroAntigo = buscarPorId(id);

			if (endereco.getCep() != null) {
				registroAntigo.setCep(endereco.getCep());
			}
			registroAntigo.setId(id);
			return enderecoRepository.save(registroAntigo);
		}

		//DELETE
		public void remover(Integer id) {
			enderecoRepository.deleteById(id);
		}
		
		public Endereco pesquisarEndereco(String cep) { //pesquisa o endreço através do CEP
			RestTemplate restTemplate = new RestTemplate(); //Cria uma nova instancia e faz uma requisição
			String uri = "http://viacep.com.br/ws/{cep}/json/"; //API da requisição das informações
			Map<String, String> params = new HashMap<>(); //faz um hashmap onde recebe dois valores string
			params.put("cep", cep); //o primeiro CEP é a chave e o segundo é a variável que será passada no parâmentro (linha 62)
			return restTemplate.getForObject(uri, Endereco.class, params); //Pega a URI, entende que o CEP vai ser preenchido com os params e retorna as informações do CEP
		}

}
