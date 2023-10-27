package br.com.api.trabalho.dto;

import java.time.LocalDate;

public class PessoaDTO {

	private String cpf;
	private String email;
	private String senha;
	private String nome;
	private LocalDate dataNascimento;
	private Long numeroCnh;
	private String categoriaHab;
	private String telefoneFixo;
	private String celular;
	private String cep;
	private String numero;
	private String complementoAdicional;
	
	public PessoaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(String cpf, String email, String senha, String nome, LocalDate dataNascimento, Long numeroCnh,
			String categoriaHab, String telefoneFixo, String celular, String cep, String numero,
			String complementoAdicional) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numeroCnh = numeroCnh;
		this.categoriaHab = categoriaHab;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.cep = cep;
		this.numero = numero;
		this.complementoAdicional = complementoAdicional;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplementoAdicional() {
		return complementoAdicional;
	}

	public void setComplementoAdicional(String complementoAdicional) {
		this.complementoAdicional = complementoAdicional;
	}

	@Override
	public String toString() {
		return "PessoaDTO [cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", nome=" + nome
				+ ", dataNascimento=" + dataNascimento + ", numeroCnh=" + numeroCnh + ", categoriaHab=" + categoriaHab
				+ ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + ", cep=" + cep + ", numero=" + numero
				+ ", complementoAdicional=" + complementoAdicional + "]";
	}

}
