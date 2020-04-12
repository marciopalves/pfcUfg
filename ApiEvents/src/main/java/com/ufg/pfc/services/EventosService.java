package com.ufg.pfc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufg.pfc.domain.Evento;
import com.ufg.pfc.repository.IEvento;
import com.ufg.pfc.services.exceptions.EventoNaoEncontradoException;

@Service
public class EventosService {
	
	public static final String EVENT_NOTFOUND = "Evento não encontrado!";

	@Autowired
	private IEvento repository;
	
	public List<Evento> listar() {
		return repository.findAll();
	}
	
	
	public Evento buscar(Long id) throws EventoNaoEncontradoException {
		Evento evento = repository.getOne(id);
		
		if (evento == null) {
			throw new EventoNaoEncontradoException(EVENT_NOTFOUND);
		}
		return evento;
	}

	public Evento salvar(Evento evento) {
		evento.setId(null);
		return repository.save(evento);
	}
	
	public void deletar(Long id) throws EventoNaoEncontradoException {
		try {			
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new EventoNaoEncontradoException(EVENT_NOTFOUND);
		}		
	}
	
	private void verificarExistencia(Evento evento) throws EventoNaoEncontradoException {
		buscar(evento.getId());
	}	
	
	public void atualizar(Evento evento) throws EventoNaoEncontradoException {
		verificarExistencia(evento);
		repository.save(evento);		
	}		
	
}
