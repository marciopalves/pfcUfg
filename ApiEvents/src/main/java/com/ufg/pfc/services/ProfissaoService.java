package com.ufg.pfc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufg.pfc.repository.IProfissaoRepository;
import com.ufg.pfc.domain.Profissao;
import com.ufg.pfc.services.exceptions.ProfissaoNaoEncontradaException;

@Service
public class ProfissaoService {
	
	public static final String PROFESSION_NOTFOUND = "Profissão não pode ser encontrada!";
	
	@Autowired
	private IProfissaoRepository repository;
	
	public List<Profissao> listar(){
		return repository.findAll();
	}
	
	public Profissao buscar(Long id) {
		Profissao profissao = repository.getOne(id);
		
		if(profissao == null) {
			throw new ProfissaoNaoEncontradaException(PROFESSION_NOTFOUND);
		}
		return profissao;
	}
	
	public Profissao salvar(Profissao profissao) {
		profissao.setId(null);
		return repository.save(profissao);
	}
	
	public void deletar(Long id) {
		try {			
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ProfissaoNaoEncontradaException(PROFESSION_NOTFOUND);
		}		
	}
	
	public void atualizar(Profissao profissao) {
		verificarExistencia(profissao);
		repository.save(profissao);		
	}
	
	private void verificarExistencia(Profissao profissao) {
		buscar(profissao.getId());
	}
}
