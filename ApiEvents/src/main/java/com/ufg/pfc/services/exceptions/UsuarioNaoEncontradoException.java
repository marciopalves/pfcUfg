package com.ufg.pfc.services.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
	
	private static final long serialversionUID = 1869300553614629710L;
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public UsuarioNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
