package com.doruleanu.Service;

import com.doruleanu.Entity.Export;
import com.doruleanu.Repository.ExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Service
public class ExportService implements IExportService {

    @Autowired
    private ExportRepository exportDao;

    @PersistenceContext
    private EntityManager eman;

    @Override
    public  Page<Export> listAllByPage(Pageable pageable) {
    	return exportDao.findAll(pageable);
	}
 
	@Override
    public Export getExportById(Long id){
    	return eman.find(Export.class, id);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Page<Export> findAllByFactura(Long factid, Pageable pageable){
        String hql = "FROM Export where factid= :factid order by id";
        List<Export> export = eman.createQuery(hql).setParameter("factid", factid).getResultList();
        Page<Export> pages = new PageImpl<Export>(export, pageable, export.size());
        return pages;
    }
    
    
    @SuppressWarnings("unchecked")
	@Override
    public Page<Export> findAllByProduct(Long id_pr, Pageable pageable){
    	String hql = "select e FROM Export e , Product p where e.id_pr = :id_pr and e.id_pr = p.id ";
        List<Export> export =  eman.createQuery(hql).setParameter("id_pr", id_pr).getResultList();
        Page<Export> pages = new PageImpl<Export>(export, pageable, export.size());
        return pages;
    }

    @Override
    public void deleteExportById(Long id) {
        exportDao.deleteById(id);
    }


    @Override
    public void updateExport(Export export) {
        exportDao.save(export);
    }


    @Override
    public void insertExportNou(Export export) {
        exportDao.save(export);
    }

}
