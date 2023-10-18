package br.com.api.trabalho.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carro")

public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Integer id;
	
	@NotNull
	@Column(name = "ativo_carro")
	private Boolean ativo = true;
	
	@NotNull
	@Column(name = "marca_carro")
	private String marca;

	@NotNull
	@Column(name = "modelo_carro")
	private String modelo;

	@NotNull
	@Column(name = "fabricacao_carro")
	private LocalDate dataFabricacao;

	@NotNull
	@Column(name = "ano_modelo_carro")
	private LocalDate dataModelo;

	@NotNull
	@Column(name = "cor_carro")
	private String cor;

	@NotNull
	@Column(name = "renavan_carro")
	private Long renavan;

	@NotNull
	@Column(name = "placa_carro")
	private String placa;

	@NotNull
	@Column(name = "chassi_carro")
	private String chassi;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Carro(Integer id, @NotNull Boolean ativo, @NotNull String marca, @NotNull String modelo,
			@NotNull LocalDate dataFabricacao, @NotNull LocalDate dataModelo, @NotNull String cor,
			@NotNull Long renavan, @NotNull String placa, @NotNull String chassi, Pessoa pessoa) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.dataModelo = dataModelo;
		this.cor = cor;
		this.renavan = renavan;
		this.placa = placa;
		this.chassi = chassi;
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

	public Long getRenavan() {
		return renavan;
	}

	public void setRenavan(Long renavan) {
		this.renavan = renavan;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", ativo=" + ativo + ", marca=" + marca + ", modelo=" + modelo + ", dataFabricacao="
				+ dataFabricacao + ", dataModelo=" + dataModelo + ", cor=" + cor + ", renavan=" + renavan + ", placa="
				+ placa + ", chassi=" + chassi + ", pessoa=" + pessoa + "]";
	}

}
