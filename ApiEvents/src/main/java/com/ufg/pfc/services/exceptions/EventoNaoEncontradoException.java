package com.ufg.pfc.services.exceptions;

public class EventoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 2930848593013420495L;

	public EventoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EventoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
