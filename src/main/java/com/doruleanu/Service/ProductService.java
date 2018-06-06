package com.doruleanu.Service;

import com.doruleanu.Repository.ProductRepository;
import com.doruleanu.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productDao;
    
    @PersistenceContext
    private EntityManager eman;

    
	@Override
    public Product getProductById(Long id) {
    	return eman.find(Product.class, id);
    }

    @Override
    public void removeProductById(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void insertProductNou(Product product) {
        productDao.save(product);
    }

}


