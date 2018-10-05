package com.ufg.pfc.services.exceptions;

public class ProfissaoNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 2930848093013420495L;

	public ProfissaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public ProfissaoNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
