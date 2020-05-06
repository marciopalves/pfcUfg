package com.ufg.pfc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	//@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JsonInclude(Include.NON_NULL)	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)	
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	@Column(unique = true)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;
	
	//@JsonInclude(Include.NON_NULL)
	private String nasciemto;
	
	//@Transient
	//private Endereco endereco;
	
	public Usuario() {
		
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNasciemto() {
		return nasciemto;
	}
	public void setNasciemto(String nasciemto) {
		this.nasciemto = nasciemto;
	}	
	
	/*
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	*/
}