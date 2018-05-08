package com.doruleanu.Service;

import com.doruleanu.Entity.Product;
import org.springframework.data.domain.Pageable;


import org.springframework.data.domain.Page;

public interface IProductService {
	
	Page<Product> listAllByPage(Pageable pageable);

    Product getProductById(Long id);

    void insertProductNou(Product product);

    void updateProduct(Product product);

    void removeProductById(Long id);

	Page<Product> getProductByCod(String prodid, Pageable pageable);

	Page<Product> getProductByName(String name, Pageable pageable);

}
