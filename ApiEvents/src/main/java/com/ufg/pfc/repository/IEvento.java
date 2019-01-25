package com.ufg.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.pfc.domain.Evento;

public interface IEvento extends JpaRepository<Evento, Long> {

}
