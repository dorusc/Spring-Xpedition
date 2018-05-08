package com.doruleanu.Service;

import com.doruleanu.Entity.Factura;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacturaService {
	
	Page<Factura> listAllByPage(Pageable pageable);
	
    Factura getFacturaById(Long id);

    void removeFacturaById(Long id);

    void updateFactura(Factura factura);

    void insertFacturaNoua(Factura factura);

//	Page<Factura> getFacturaByClientId(Integer clientid, Pageable pageable);

}
