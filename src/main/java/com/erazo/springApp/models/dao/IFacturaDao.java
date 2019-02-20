package com.erazo.springApp.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.erazo.springApp.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
