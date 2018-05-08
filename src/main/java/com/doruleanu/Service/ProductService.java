package com.doruleanu.Service;

import com.doruleanu.Repository.ProductRepository;
import com.doruleanu.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository ProductDao;
    
    @PersistenceContext
    private EntityManager eman;

    @Override
    public  Page<Product> listAllByPage(Pageable pageable) {
    	return ProductDao.findAll(pageable);
	}

    @SuppressWarnings("unchecked")
	@Override
    public Page<Product> getProductByCod(String prodid, Pageable pageable){
    	String hql = "FROM Product as cat where cat.prodid like :prodid order by prodid";
        List<Product> produse = eman.createQuery(hql).setParameter("prodid", "%"+prodid+"%").getResultList();
        Page<Product> pages = new PageImpl<Product>(produse, pageable, produse.size());
        //Page<Product> pages = new PageImpl<Product>(produse, pageable, produse.size());
		return pages;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Page<Product> getProductByName(String name, Pageable pageable){
    	String hql = "FROM Product as cat where cat.denumire like :denumire order by denumire";
        List<Product> produse = eman.createQuery(hql).setParameter("denumire", "%"+name+"%").getResultList();
        Page<Product> pages = new PageImpl<Product>(produse, pageable, produse.size());
		return pages;
    }
    
	@Override
    public Product getProductById(Long id) {
    	return eman.find(Product.class, id);
    }

    @Override
    public void removeProductById(Long id) {
        ProductDao.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        ProductDao.save(product);
    }

    @Override
    public void insertProductNou(Product product) {
        ProductDao.save(product);
    }

}


