package com.erazo.springApp.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.erazo.springApp.models.entity.Cliente;
import com.erazo.springApp.models.service.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
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

	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		cliente.setCreateAt(new Date());
		return clienteService.save(cliente);
	}
	
}