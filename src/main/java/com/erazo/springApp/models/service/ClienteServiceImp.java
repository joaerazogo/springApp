package com.erazo.springApp.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
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
	@Transactional(readOnly=true)
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
}