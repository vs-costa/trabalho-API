package br.com.api.trabalho.dto;

public class EnderecoDTO {

	private String cep;
	private String complemento;
	private String numeroResidência;

	public EnderecoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnderecoDTO(String cep, String complemento, String numeroResidência) {
		super();
		this.cep = cep;
		this.complemento = complemento;
		this.numeroResidência = numeroResidência;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumeroResidência() {
		return numeroResidência;
	}

	public void setNumeroResidência(String numeroResidência) {
		this.numeroResidência = numeroResidência;
	}

}
