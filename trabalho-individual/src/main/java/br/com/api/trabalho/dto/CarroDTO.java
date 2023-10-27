package br.com.api.trabalho.dto;

import java.time.LocalDate;

public class CarroDTO {

	
	private String marca;
	private String modelo;
	private LocalDate dataFabricacao;
	private LocalDate dataModelo;
	private String cor;
	private String renavam;
	private String placa;
	private String chassi;
	
	public CarroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarroDTO(String marca, String modelo, LocalDate dataFabricacao, LocalDate dataModelo, String cor,
			String renavam, String placa, String chassi) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.dataModelo = dataModelo;
		this.cor = cor;
		this.renavam = renavam;
		this.placa = placa;
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataModelo() {
		return dataModelo;
	}

	public void setDataModelo(LocalDate dataModelo) {
		this.dataModelo = dataModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
		
}
