package com.doruleanu.Repository;

import com.doruleanu.Entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Page<Product> findAll(Pageable pageable);
	
	@Query("select p FROM Product p where prodid like concat('%',:prodid, '%') order by prodid")
	Page<Product> product1(@Param("prodid")String prodid, Pageable pageable);

	@Query("select p FROM Product p where denumire like concat('%',:name, '%') order by denumire")
	Page<Product> product2(@Param("name")String name, Pageable pageable);

}