package com.erazo.springApp.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.erazo.springApp.models.entity.Cliente;

public interface IClienteService {
	
	public ResponseEntity<List<Cliente>> findAll();
	public Page<Cliente> findAll(Pageable pageable);
	public Cliente findById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(Cliente cliente);

}