package com.doruleanu.Service;

import com.doruleanu.Entity.Factura;


public interface IFacturaService {
	
	
    Factura getFacturaById(Long id);

    void removeFacturaById(Long id);

	void updateFactura(Long id, Integer clientid, Factura factura);

	void insertFacturaNoua(Integer clientid, Factura factura);


}
