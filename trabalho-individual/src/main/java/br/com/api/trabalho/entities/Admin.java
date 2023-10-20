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
@Table(name = "system_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin")
	private Integer id;

	@NotNull
	@Column(name = "ativo_admin")
	private Boolean ativo = true;

	@NotNull
	@Column(name = "nome_admin")
	private String nome;

	@NotNull
	@Size(max = 11)
	@Column(name = "cpf_admin")
	private String cpf;

	@NotNull
	@Size(max = 10)
	@Column(name = "senha_admin")
	private String senha;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Admin(Integer id, @NotNull Boolean ativo, @NotNull String nome, @NotNull @Size(max = 11) String cpf,
			@NotNull @Size(max = 10) String senha, br.com.api.trabalho.entities.User user) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.user = user;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", ativo=" + ativo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", user=" + user + "]";
	}

}
