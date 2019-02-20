package com.erazo.springApp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.erazo.springApp.models.dao.IFacturaDao;
import com.erazo.springApp.models.entity.Factura;

@Service
public class FacturaServiceImp implements IFacturaService{
	
	private IFacturaDao facturaDao;
	
	@Autowired
	public FacturaServiceImp(IFacturaDao fact) {
		this.facturaDao = fact;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Factura> findAll() {
		return (List<Factura>) facturaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}
	
	@Override
	public Factura save(Factura factura) {
		return facturaDao.save(factura);
	}
	
	@Override
	@Transactional(readOnly=true)
	public void delete(Long id) {
		facturaDao.deleteById(id);
	}
	
}
