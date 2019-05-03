package com.erazo.springApp.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erazo.springApp.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
}