package com.doruleanu.Service;

import com.doruleanu.Entity.Client;
import com.doruleanu.Entity.Factura;
import com.doruleanu.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;


@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private FacturaRepository facturaRepo;
    
    @Autowired
    private EntityManager eman;


/*    @Override
    public  Page<Factura> listAllByPage(Pageable pageable) {
    	return facturaRepo.findAll(pageable);
	}
*/
    
	@Override
    public Factura getFacturaById(Long id){
    	 return eman.find(Factura.class, id);
    }
	
/*	@SuppressWarnings("unchecked")
	@Override
    public Page<Factura> getFacturaByClientId(Integer clientid, Pageable pageable){
    	String hql = "FROM Factura as fact where fact.clientid = :clientid order by factid";
        List<Factura>facturi = eman.createQuery(hql).setParameter("clientid", clientid).getResultList();
        Page<Factura> pages = new PageImpl<Factura>(facturi, pageable, facturi.size());

		return pages;
    }
*/
    @Override
    public void removeFacturaById(Long id) {
    	facturaRepo.deleteById(id);
    }

    @Override
    public void updateFactura(Long id, Integer clientid, Factura factura) {
    	factura.setClient(eman.find(Client.class, clientid));
    	factura.setId(id);
        facturaRepo.save(factura);
    }

    @Override
    public void insertFacturaNoua(Integer clientid, Factura factura) {
    	factura.setClient(eman.find(Client.class, clientid));
        facturaRepo.save(factura);
    }

	
}
