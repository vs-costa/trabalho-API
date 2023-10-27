package br.com.api.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabalho.entities.Carro;
import br.com.api.trabalho.repositories.CarroRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;

	// GET Id
	public Carro buscarPorId(Integer id) {
		return carroRepository.findById(id).get();
	}

	// GET Listar
	public List<Carro> listarTodos() {
		return carroRepository.findAll();
	}

	// POST
	public Carro salvar(Carro carro) {
		return carroRepository.save(carro);
	}

	// PUT
	public Carro atualizar(Integer id, Carro carro) {
		Carro registro = buscarPorId(id);

		if (carro.getMarca() != null) {
			registro.setMarca(carro.getMarca());
		}
		if (carro.getModelo() != null) {
			registro.setModelo(carro.getModelo());
		}
		if (carro.getDataFabricacao() != null) {
			registro.setDataFabricacao(carro.getDataFabricacao());
		}
		if (carro.getDataModelo() != null) {
			registro.setDataModelo(carro.getDataModelo());
		}
		if (carro.getCor() != null) {
			registro.setCor(carro.getCor());
		}
		if (carro.getRenavam() != null) {
			registro.setRenavam(carro.getRenavam());
		}
		if (carro.getPlaca() != null) {
			registro.setPlaca(carro.getPlaca());
		}
		if (carro.getChassi() != null) {
			registro.setChassi(carro.getChassi());
		}
		registro.setId(id);
		return carroRepository.save(registro);
	}

	// Delete lógico
	public void removerLogico(Integer id) {
		Carro carro = buscarPorId(id);

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
