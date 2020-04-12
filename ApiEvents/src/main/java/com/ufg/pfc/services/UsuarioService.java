package com.ufg.pfc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ufg.pfc.repository.IUsuarioRepository;
import com.ufg.pfc.domain.Usuario;
import com.ufg.pfc.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {
	
	public static final String USER_NOTFOUND = "Usuário não pode ser encontrado!";
	
	@Autowired
	private IUsuarioRepository repository;
	
	public List<Usuario> listar(){
		return repository.findAll();		
	}
	
	public Usuario buscar(Long id) {
		Usuario usuario = repository.getOne(id);
		if (usuario == null) {
			throw new UsuarioNaoEncontradoException(USER_NOTFOUND);
		}
		return usuario;
	}
	
	public Usuario salvar(Usuario usuario) {
		usuario.setId(null);
		return  repository.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException(USER_NOTFOUND);
		}
	}
	
	public void atualiza(Usuario usuario) {
		verificarExistencia(usuario);
		repository.save(usuario);
	}
	
	private void verificarExistencia(Usuario usuario) {
		buscar(usuario.getId());
	}
}