package br.com.api.trabalho.dto;

public class CarroAtualizarDTO {

	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String cor;
	private String renavam;
	private String placa;
	private String chassi;

	public CarroAtualizarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarroAtualizarDTO(String marca, String modelo, Integer anoFabricacao, Integer anoModelo, String cor,
			String renavam, String placa, String chassi) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
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

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
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
