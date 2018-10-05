package com.ufg.pfc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Endereco {

	@JsonInclude(Include.NON_NULL)
	private String logradouro;

	@JsonInclude(Include.NON_NULL)
	private String complemento;

	@JsonInclude(Include.NON_NULL)
	private String cep;

	@JsonInclude(Include.NON_NULL)
	private String cidade;

	@JsonInclude(Include.NON_NULL)
	private String uf;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Endereço " + this.logradouro + " " + this.complemento + " cep:" + this.cep + " " + this.cidade + " "
				+ this.uf;
	}

}