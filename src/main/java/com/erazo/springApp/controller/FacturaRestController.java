package com.erazo.springApp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.erazo.springApp.models.entity.Factura;
import com.erazo.springApp.models.service.IClienteService;
import com.erazo.springApp.models.service.IFacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaRestController {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	public FacturaRestController(IFacturaService fact) {
		// TODO //Auto-generated constructor stub
		this.facturaService = fact;
	}

	@GetMapping("/leerFacturas")
	public ResponseEntity<List<Factura>> index() {
		List<Factura> facturas = facturaService.findAll();

		if (facturas.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(facturas, HttpStatus.OK);
	}

	@PostMapping("/guardarFacturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura create(@PathVariable(value = "id") Long id_client,
	@Valid @RequestBody Factura factura) {
		factura.setFecha(new Date());
		return facturaService.save(factura);
		/*
		return clienteService.findById(id_client)
				.map(cliente -> {
					factura.setCliente(cliente);
					return facturaService.save(factura);
		}).orElseThrow(() -> new ResourceNotFoundException("id_client " + id_client + " not found"));
		*/
	}

}
