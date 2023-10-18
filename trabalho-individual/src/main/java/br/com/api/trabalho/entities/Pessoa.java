package br.com.api.trabalho.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")

public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;
	
	@NotNull
	@Column(name = "ativo_pessoa")
	private Boolean ativo = true;

	@NotNull
	@Column(name = "cpf")
	private String cpf;

	@NotNull
	@Column(name = "nome_pessoa")
	private String nome;

	@NotNull
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@NotNull
	@Column(name = "registro_habilitacao")
	private Long registroHab;

	@NotNull
	@Column(name = "carteira_habilitacao")
	private String carteiraHab;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@Column(name = "celular")
	private String celular;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany
	@JoinColumn(name = "carro_id")
	private List<Carro> carro;

	public Pessoa(Integer id, @NotNull Boolean ativo, @NotNull String cpf, @NotNull String nome,
			@NotNull LocalDate dataNascimento, @NotNull Long registroHab, @NotNull String carteiraHab,
			String telefoneFixo, String celular, Endereco endereco, List<Carro> carro) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.registroHab = registroHab;
		this.carteiraHab = carteiraHab;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.endereco = endereco;
		this.carro = carro;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getRegistroHab() {
		return registroHab;
	}

	public void setRegistroHab(Long registroHab) {
		this.registroHab = registroHab;
	}

	public String getCarteiraHab() {
		return carteiraHab;
	}

	public void setCarteiraHab(String carteiraHab) {
		this.carteiraHab = carteiraHab;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Carro> getCarro() {
		return carro;
	}

	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", ativo=" + ativo + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + ", registroHab=" + registroHab + ", carteiraHab=" + carteiraHab + ", telefoneFixo="
				+ telefoneFixo + ", celular=" + celular + ", endereco=" + endereco + ", carro=" + carro + "]";
	}

}
