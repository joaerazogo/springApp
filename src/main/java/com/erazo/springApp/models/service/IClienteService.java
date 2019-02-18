package com.erazo.springApp.models.service;

import java.util.List;

import com.erazo.springApp.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();

}