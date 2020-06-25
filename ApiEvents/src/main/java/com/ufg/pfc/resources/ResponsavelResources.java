package com.ufg.pfc.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufg.pfc.domain.Responsavel;
import com.ufg.pfc.services.ResponsavelService;

@RestController
@RequestMapping(value = "/responsaveis")
public class ResponsavelResources {

	@Autowired
	private ResponsavelService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Responsavel>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Responsavel responsavel) {
		responsavel = service.salvar(responsavel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(responsavel.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Responsavel responsavel = responsavel = service.busca(id);
		return ResponseEntity.status(HttpStatus.OK).body(responsavel);
	}

	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {		
		service.deletar(id);					
		return ResponseEntity.noContent().build();		 
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Responsavel responsavel, @PathVariable("id") Long id) {
		responsavel.setId(id);		
		service.atualiza(responsavel);		
		return ResponseEntity.noContent().build();
	}		
}
