package br.com.api.trabalho.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_carro")

public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Integer id;

	@Column(name = "ativo_carro")
	private Boolean ativo = true;

	@NotNull
	@Column(name = "marca_carro")
	private String marca;

	@NotNull
	@Column(name = "modelo_carro")
	private String modelo;

	@NotNull
	@Column(name = "ano_fabricacao_carro")
	private Integer anoFabricacao;

	@NotNull
	@Column(name = "ano_modelo_carro")
	private Integer anoModelo;

	@NotNull
	@Column(name = "cor_carro")
	private String cor;

	@NotNull
	@Column(name = "renavam_carro")
	private String renavam;

	@NotNull
	@Size(max = 7)
	@Column(name = "placa_carro")
	private String placa;

	@NotNull
	@Size(max = 17)
	@Column(name = "chassi_carro")
	private String chassi;

	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carro(Integer id, Boolean ativo, @NotNull String marca, @NotNull String modelo,
			@NotNull Integer anoFabricacao, @NotNull Integer anoModelo, @NotNull String cor,
			@NotNull @Size(max = 9) String renavam, @NotNull @Size(max = 7) String placa,
			@NotNull @Size(max = 17) String chassi, Pessoa pessoa) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.cor = cor;
		this.renavam = renavam;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", ativo=" + ativo + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao="
				+ anoFabricacao + ", anoModelo=" + anoModelo + ", cor=" + cor + ", renavam=" + renavam + ", placa="
				+ placa + ", chassi=" + chassi + ", pessoa=" + pessoa + "]";
	}

}
