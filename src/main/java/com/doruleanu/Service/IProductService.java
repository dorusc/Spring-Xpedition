package com.doruleanu.Service;

import com.doruleanu.Entity.Product;


public interface IProductService {
	
	Product getProductById(Long id);

	void removeProductById(Long id);

	void updateProduct(Product product);

	void insertProductNou(Product product);

}
