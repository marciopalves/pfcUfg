package com.ufg.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufg.pfc.domain.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
