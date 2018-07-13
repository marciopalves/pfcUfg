package com.ufg.pfc.resources;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withNoContent;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufg.ApiEvents.repository.IProfissoesRepository;
import com.ufg.pfc.domain.Profissao;
import com.ufg.pfc.services.ProfissoesService;
import com.ufg.pfc.services.exceptions.ProfissaoNaoEncontradaException;

@RestController
@RequestMapping("/profissoes")
public class ProfissoesResources {
	
	@Autowired
	private ProfissoesService service; 

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Profissao>> listar() {		  
		  return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Profissao profissao) {			
			profissao = service.salvar(profissao);			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(profissao.getId()).toUri();			
			return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		try {
			Profissao profissao = service.buscar(id);
		}catch(ProfissaoNaoEncontradaException e){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());			
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Profissao profissao, @PathVariable("id") Long id){		
			profissao.setId(id);
			try {
				service.atualizar(profissao);
			} catch (ProfissaoNaoEncontradaException e) {
				ResponseEntity.notFound().build();
			}					
			return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		
		try {
			service.deletar(id);			
		}catch(ProfissaoNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.noContent().build();				
	}
	
}
