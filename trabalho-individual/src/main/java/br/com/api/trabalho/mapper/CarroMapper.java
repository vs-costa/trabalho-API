package br.com.api.trabalho.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.trabalho.dto.CarroAtualizarDTO;
import br.com.api.trabalho.dto.CarroDTO;
import br.com.api.trabalho.entities.Carro;
import br.com.api.trabalho.services.CarroService;

@Component
public class CarroMapper {

	@Autowired
	CarroService carroService;

	// Converter DTO
	public CarroDTO converterCarroDTO(Carro carro) {
		CarroDTO carroConvertido = new CarroDTO();
		carroConvertido.setMarca(carro.getMarca());
		carroConvertido.setModelo(carro.getModelo());
		carroConvertido.setAnoFabricacao(carro.getAnoFabricacao());
		carroConvertido.setAnoModelo(carro.getAnoModelo());
		carroConvertido.setCor(carro.getCor());
		carroConvertido.setRenavam(carro.getRenavam());
		carroConvertido.setPlaca(carro.getPlaca());
		carroConvertido.setChassi(carro.getChassi());
		carroConvertido.setCategoriaHab(carro.getPessoa().getCategoriaHab());
		carroConvertido.setNome(carro.getPessoa().getNome());
		carroConvertido.setNumeroCnh(carro.getPessoa().getNumeroCnh());
		return carroConvertido;
	}

	// Atualizar DTO
	public CarroAtualizarDTO converterCarroAtualizarDTO(Carro carro) {
		CarroAtualizarDTO carroConvertido = new CarroAtualizarDTO();
		carroConvertido.setMarca(carro.getMarca());
		carroConvertido.setModelo(carro.getModelo());
		carroConvertido.setAnoFabricacao(carro.getAnoFabricacao());
		carroConvertido.setAnoModelo(carro.getAnoModelo());
		carroConvertido.setCor(carro.getCor());
		carroConvertido.setRenavam(carro.getRenavam());
		carroConvertido.setPlaca(carro.getPlaca());
		carroConvertido.setChassi(carro.getChassi());
		return carroConvertido;
	}

}
