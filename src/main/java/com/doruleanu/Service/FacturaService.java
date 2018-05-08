package com.doruleanu.Service;

import com.doruleanu.Entity.Factura;
import com.doruleanu.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private FacturaRepository facturaDao;
    
    @PersistenceContext
    private EntityManager eman;



    @Override
    public  Page<Factura> listAllByPage(Pageable pageable) {
    	return facturaDao.findAll(pageable);
	}

	@Override
    public Factura getFacturaById(Long id){
    	 return eman.find(Factura.class, id);
    }
	
	//@SuppressWarnings("unchecked")
/*	@Override
    public Page<Factura> getFacturaByClientId(Integer clientid, Pageable pageable){
/*    	String hql = "FROM Factura where clientid = :clientid order by id";
        List<Factura>facturi = eman.createQuery(hql).setParameter("clientid", clientid).getResultList();
        Page<Factura> pages = new PageImpl<Factura>(facturi, pageable, facturi.size());
		return pages;

		return facturaDao.fact(clientid, pageable);
    }
*/
    @Override
    public void removeFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    public void updateFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public void insertFacturaNoua(Factura factura) {
        facturaDao.save(factura);
    }

}
