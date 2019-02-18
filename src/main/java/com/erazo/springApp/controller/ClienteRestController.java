package com.erazo.springApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erazo.springApp.models.entity.Cliente;
import com.erazo.springApp.models.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	private IClienteService clienteService;
	
	public ClienteRestController(IClienteService cs) {
		this.clienteService=cs;
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> index() {
		List<Cliente> clientes = clienteService.findAll();
		
		if(clientes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}


}