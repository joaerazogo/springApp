package com.erazo.springApp.models.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	public Cliente findById(Long id) {
		
		return clienteDao.findById(id).orElse(null);
		
	}
	
	@Override
	public ResponseEntity<?> save(Cliente cliente) {
		
		Cliente clientNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente.setCreateAt(new Date());
			clientNew = clienteDao.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción a la base de datos");
			response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente se ha creado con éxito");
		response.put("cliente", clientNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Override
	@Transactional(readOnly=true)
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
}