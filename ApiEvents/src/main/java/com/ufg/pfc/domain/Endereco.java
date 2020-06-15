package com.ufg.pfc.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Embeddable
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private Long id; 

	//@JsonInclude(Include.NON_NULL)
	private String logradouro;

	//@JsonInclude(Include.NON_NULL)
	private String complemento;

	//@JsonInclude(Include.NON_NULL)
	private String cep;

	//@JsonInclude(Include.NON_NULL)
	private String cidade;

	//@JsonInclude(Include.NON_NULL)
	private String uf;
	
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}

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