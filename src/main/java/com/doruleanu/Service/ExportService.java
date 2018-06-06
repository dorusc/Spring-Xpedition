package com.doruleanu.Service;

import com.doruleanu.Entity.Export;
import com.doruleanu.Entity.Factura;
import com.doruleanu.Entity.Product;
import com.doruleanu.Repository.ExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Service
public class ExportService implements IExportService {

    @Autowired
    private ExportRepository exportRepo;

    @PersistenceContext
    private EntityManager eman;
    
    public BigDecimal calcweight;
    
 /*   @Override
    public  Page<Export> listAllByPage(Pageable pageable) {
    	return exportRepo.findAll(pageable);
	}
 */
	@Override
    public Export getExportById(Long id){
    	return eman.find(Export.class, id);
    }
    
/*    @SuppressWarnings("unchecked")
	@Override
    public Page<Export> findAllByFactura(Long factid, Pageable pageable){
        String hql = "FROM Export where factid= :factid order by id";
        List<Export> export = eman.createQuery(hql).setParameter("factid", factid).getResultList();
        Page<Export> pages = new PageImpl<Export>(export, pageable, export.size());
        return pages;
    }
*/ 
    
 /*   @SuppressWarnings("unchecked")
	@Override
    public Page<Export> findAllByProduct(Long id_pr, Pageable pageable){
    	String hql = "select e FROM Export e , Product p where e.id_pr = :id_pr and e.id_pr = p.id ";
        List<Export> export =  eman.createQuery(hql).setParameter("id_pr", id_pr).getResultList();
        Page<Export> pages = new PageImpl<Export>(export, pageable, export.size());
        return pages;
    }
*/
    @Override
    public void deleteExportById(Long id) {
        exportRepo.deleteById(id);
    }


    @Override
	public void updateExport(Long id, Long idprod, Long idfact, Export export) {
    	export.setId(id);
    	Product product = eman.find(Product.class, idprod);
		export.setProduct(product);
		
		export.setFactura(eman.find(Factura.class, idfact));
		
		calcweight = product.getWeight().multiply(export.getCant());
		export.setWeight(calcweight);
		exportRepo.save(export);
	}


    @Override
    public void insertExportNou(Long idfact, Long idprod, Export export) {
    	Product product = eman.find(Product.class, idprod);
    	export.setProduct(product);
    	
    	export.setFactura(eman.find(Factura.class, idfact));
		
		calcweight = product.getWeight().multiply(export.getCant());
		export.setWeight(calcweight);
        exportRepo.save(export);
    }

   
}
