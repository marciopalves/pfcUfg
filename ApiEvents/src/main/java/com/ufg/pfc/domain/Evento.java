package com.ufg.pfc.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private LocalDateTime data;
	
	@OneToOne
	private Responsavel responsavel;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> profisionais;
	
}
