package com.erazo.springApp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erazo.springApp.models.dao.IClienteDao;
import com.erazo.springApp.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{
	
	private IClienteDao clienteDao;
	
	@Autowired
	public ClienteServiceImp(IClienteDao cd) {
		this.clienteDao = cd;
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
		
		if(clientes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		
		return clienteDao.findById(id).orElse(null);
		
	}
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@Override
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
}