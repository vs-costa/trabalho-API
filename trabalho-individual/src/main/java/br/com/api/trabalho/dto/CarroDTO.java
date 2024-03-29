package br.com.api.trabalho.dto;

public class CarroDTO {

	// Informações da entidade Carro
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String cor;
	private String renavam;
	private String placa;
	private String chassi;

	// Informações da entidade Pessoa
	private String categoriaHab;
	private String nome;
	private Long numeroCnh;

	public CarroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarroDTO(String marca, String modelo, Integer anoFabricacao, Integer anoModelo, String cor, String renavam,
			String placa, String chassi, String categoriaHab, String nome, Long numeroCnh) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.cor = cor;
		this.renavam = renavam;
		this.placa = placa;
		this.chassi = chassi;
		this.categoriaHab = categoriaHab;
		this.nome = nome;
		this.numeroCnh = numeroCnh;
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

	public String getCategoriaHab() {
		return categoriaHab;
	}

	public void setCategoriaHab(String categoriaHab) {
		this.categoriaHab = categoriaHab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(Long numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

}
