package com.erazo.springApp.models.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.erazo.springApp.models.entity.Cliente;

public interface IClienteService {
	
	public ResponseEntity<List<Cliente>> findAll();
	public Cliente findById(Long id);
	public ResponseEntity<?> save(Cliente cliente);
	public void delete(Cliente cliente);

}