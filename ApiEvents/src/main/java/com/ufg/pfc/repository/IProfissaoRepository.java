package com.ufg.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.pfc.domain.Profissao;

public interface IProfissaoRepository extends JpaRepository<Profissao, Long> {

}
