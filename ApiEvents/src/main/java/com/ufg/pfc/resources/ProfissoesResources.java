package com.ufg.pfc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ProfissoesResources {

	@RequestMapping(value = "/profissao")
	public String listar() {
		return "garçon, cozinheiro, churrasqueiro";
	}		
	
}
