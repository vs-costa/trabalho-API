package br.com.api.trabalho.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.dto.CarroAtualizarDTO;
import br.com.api.trabalho.dto.CarroDTO;
import br.com.api.trabalho.entities.Carro;
import br.com.api.trabalho.entities.Pessoa;
import br.com.api.trabalho.mapper.CarroMapper;
import br.com.api.trabalho.repositories.CarroRepository;
import br.com.api.trabalho.repositories.PessoaRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	CarroMapper carroMapper;
	
	@Autowired
	PessoaRepository pessoaRepository;

	// GET Id
	public CarroDTO buscarPorId(Integer id) {
		CarroDTO infoCarro = new CarroDTO();
		Carro carro = carroRepository.findById(id).get();
		infoCarro  = carroMapper.converterCarroDTO(carro);
		return infoCarro;
	}

	// GET Listar
	public List<CarroDTO> listarTodos() {
		List<CarroDTO> infoCarros = new ArrayList<>();
		List<Carro> carros = carroRepository.findAll();
		for (Carro carro : carros) {
			infoCarros.add(carroMapper.converterCarroDTO(carro));
		}
		return infoCarros;
	}

	// POST
	public Carro salvar(CarroDTO carroDTO, String nomePessoa) {
	    Pessoa pessoa = pessoaRepository.findByNome(nomePessoa).orElse(null);
	    
	    if (pessoa != null) {
	        Carro carro = new Carro();
	        Carro carroSalvar = new Carro();
			carroSalvar.setMarca(carroDTO.getMarca());
			carroSalvar.setModelo(carroDTO.getModelo());
			carroSalvar.setAnoFabricacao(carroDTO.getAnoFabricacao());
			carroSalvar.setAnoModelo(carroDTO.getAnoModelo());
			carroSalvar.setCor(carroDTO.getCor());
			carroSalvar.setRenavam(carroDTO.getRenavam());
			carroSalvar.setPlaca(carroDTO.getPlaca());
			carroSalvar.setChassi(carroDTO.getChassi());
	        carroSalvar.setPessoa(pessoa);
	        
	        return carroRepository.save(carro);
//	        Carro carroSalvo = carroRepository.save(carro);
//	        return carroMapper.converterCarroDTO(carroSalvo);
	    } else {
	        return null;
	    }
	}

	// PUT
	public CarroAtualizarDTO atualizar(Integer id, CarroAtualizarDTO carroDTO) {
		Carro registroAntigo = carroRepository.findById(id).get();

		if (carroDTO.getMarca() != null) {
			registroAntigo.setMarca(carroDTO.getMarca());
		}
		if (carroDTO.getModelo() != null) {
			registroAntigo.setModelo(carroDTO.getModelo());
		}
		if (carroDTO.getAnoFabricacao() != null) {
			registroAntigo.setAnoFabricacao(carroDTO.getAnoFabricacao());
		}
		if (carroDTO.getAnoModelo() != null) {
			registroAntigo.setAnoModelo(carroDTO.getAnoModelo());
		}
		if (carroDTO.getCor() != null) {
			registroAntigo.setCor(carroDTO.getCor());
		}
		if (carroDTO.getRenavam() != null) {
			registroAntigo.setRenavam(carroDTO.getRenavam());
		}
		if (carroDTO.getPlaca() != null) {
			registroAntigo.setPlaca(carroDTO.getPlaca());
		}
		if (carroDTO.getChassi() != null) {
			registroAntigo.setChassi(carroDTO.getChassi());
		}
		CarroAtualizarDTO carroConvertido = carroMapper.converterCarroAtualizarDTO(registroAntigo);
		registroAntigo.setId(id);
		carroRepository.save(registroAntigo);
		return carroConvertido;
	}

	// Delete lógico
	public void removerLogico(Integer id) {
		Carro carro = carroRepository.findById(id).get();

		if (carro != null) {
			carro.setAtivo(false);
			carroRepository.save(carro);
		}

	}

	// Ativar Lógico
	public void ativarLogico(Integer id) {
		Carro carro = carroRepository.findById(id).get();

		if (carro != null) {
			carro.setAtivo(true);
			carroRepository.save(carro);
		}
	}
}
