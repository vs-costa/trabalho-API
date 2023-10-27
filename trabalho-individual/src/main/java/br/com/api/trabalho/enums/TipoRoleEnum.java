package br.com.api.trabalho.enums;

public enum TipoRoleEnum {

	ROLE_PESSOA("PESSOA");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}