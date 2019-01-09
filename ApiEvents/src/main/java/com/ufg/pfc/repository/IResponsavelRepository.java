package com.ufg.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.pfc.domain.Responsavel;

public interface IResponsavelRepository extends JpaRepository<Responsavel, Long> {
	
}
