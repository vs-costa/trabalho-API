package br.com.api.trabalho.dto;

public class PessoaAtualizarDTO {

	private String email;
	private String senha;
	private String categoriaHab;
	private String telefoneFixo;
	private String celular;
	private String cep;
	private String numeroResidencia;
	private String complementoAdicional;

	public PessoaAtualizarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaAtualizarDTO(String email, String senha, String categoriaHab, String telefoneFixo, String celular,
			String cep, String numeroResidencia, String complementoAdicional) {
		super();
		this.email = email;
		this.senha = senha;
		this.categoriaHab = categoriaHab;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.cep = cep;
		this.numeroResidencia = numeroResidencia;
		this.complementoAdicional = complementoAdicional;
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

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getComplementoAdicional() {
		return complementoAdicional;
	}

	public void setComplementoAdicional(String complementoAdicional) {
		this.complementoAdicional = complementoAdicional;
	}

}
