package com.ufg.pfc.services.exceptions;

public class ResponsavelNaoEncontradoException extends RuntimeException{
	
	private static final long serialversionUID = 1869300553614629711L;
	

	public ResponsavelNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ResponsavelNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}


}
