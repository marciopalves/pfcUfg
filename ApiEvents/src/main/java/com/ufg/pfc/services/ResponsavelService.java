package com.ufg.pfc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufg.pfc.domain.Responsavel;
import com.ufg.pfc.repository.IResponsavelRepository;
import com.ufg.pfc.services.exceptions.ResponsavelNaoEncontradoException;
import com.ufg.pfc.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class ResponsavelService {
	
	public static final String RESPONSIBLE_NOTFOUND = "Responsável não pode ser encontrado!";

	@Autowired
	private IResponsavelRepository repository;
	
	public List<Responsavel> listar(){
		return repository.findAll();
	}
	
	public Responsavel busca(Long id) {
		Responsavel responsavel = repository.getOne(id);
		if (responsavel == null) {
			throw new UsuarioNaoEncontradoException(RESPONSIBLE_NOTFOUND);
		}
		return responsavel;
	}
	
	public Responsavel salvar(Responsavel responsavel) {
		responsavel.setId(null);
		return  repository.save(responsavel);
	}
	
	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResponsavelNaoEncontradoException(RESPONSIBLE_NOTFOUND);
		}
	}
	
	public void atualiza(Responsavel responsavel) {
		verificarExistencia(responsavel);
		repository.save(responsavel);
	}
	
	private void verificarExistencia(Responsavel responsavel) {
		busca(responsavel.getId());
	}
}
