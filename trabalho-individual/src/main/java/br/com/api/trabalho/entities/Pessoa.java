package br.com.api.trabalho.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_pessoa")

public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;

	@NotNull
	@Column(name = "ativo_pessoa")
	private Boolean ativo = true;

	@NotNull(message = "Campo CPF não pode ser nulo.")
	@CPF
	@Size(max = 14)
	@Column(name = "cpf")
	private String cpf;

	@NotNull(message = "Campo e-mail não pode ser nulo.")
	@Email
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	@Column(name = "email_pessoa")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull(message = "Campo senha não pode ser nulo.")
	@Column(name = "senha_pessoa")
	private String senha;

	@NotNull(message = "Campo nome não pode ser nulo.")
	@Column(name = "nome_pessoa")
	private String nome;

	@NotNull(message = "Campo data de nascimento não pode ser nulo")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@NotNull(message = "Campo Número CNH não pode ser nulo")
	@Column(name = "numero_cnh")
	private Long numeroCnh;

	@NotNull(message = "Campo Categoria Habilitação não pode ser nulo")
	@Column(name = "categoria_habilitação")
	private String categoriaHab;

	@Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}")
	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
	@Column(name = "celular")
	private String celular;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "carro_id")
	private Carro carro;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Pessoa(Integer id, @NotNull Boolean ativo,
			@NotNull(message = "Campo CPF não pode ser nulo.") @CPF @Size(max = 14) String cpf,
			@NotNull(message = "Campo e-mail não pode ser nulo.") @Email @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email,
			@NotNull(message = "Campo senha não pode ser nulo.") String senha,
			@NotNull(message = "Campo nome não pode ser nulo.") String nome,
			@NotNull(message = "Campo data de nascimento não pode ser nulo") LocalDate dataNascimento,
			@NotNull(message = "Campo Número CNH não pode ser nulo") Long numeroCnh,
			@NotNull(message = "Campo Categoria Habilitação não pode ser nulo") String categoriaHab,
			@Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}") String telefoneFixo,
			@Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}") String celular, Endereco endereco, Carro carro, User user) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numeroCnh = numeroCnh;
		this.categoriaHab = categoriaHab;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.endereco = endereco;
		this.carro = carro;
		this.user = user;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Long getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(Long numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public String getCategoriaHab() {
		return categoriaHab;
	}

	public void setCategoriaHab(String categoriaHab) {
		this.categoriaHab = categoriaHab;
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

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", ativo=" + ativo + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", numeroCnh=" + numeroCnh
				+ ", categoriaHab=" + categoriaHab + ", telefoneFixo=" + telefoneFixo + ", celular=" + celular
				+ ", endereco=" + endereco + ", carro=" + carro + ", user=" + user + "]";
	}

}
