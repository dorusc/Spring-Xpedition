package com.doruleanu.Repository;

import com.doruleanu.Entity.Factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository

	public interface FacturaRepository extends PagingAndSortingRepository<Factura, Long> {
	
		@Query("select f FROM Factura f where client.id = ?1 order by id")
		Page<Factura> factura(Integer clientid, Pageable pageable);
		
		
		Page<Factura> findAll(Pageable pageable);

}