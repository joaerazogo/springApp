package com.erazo.springApp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.erazo.springApp.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}