package com.ufg.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.pfc.domain.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
