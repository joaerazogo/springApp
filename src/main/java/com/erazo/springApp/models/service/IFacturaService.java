package com.erazo.springApp.models.service;

import java.util.List;
import com.erazo.springApp.models.entity.Factura;

public interface IFacturaService {
	
	public List<Factura> findAll();
	public Factura findById(Long id);
	public Factura save(Factura factura);
	public void delete(Long id);
	
}
