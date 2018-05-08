package com.doruleanu.Repository;

import com.doruleanu.Entity.Factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface FacturaRepository extends PagingAndSortingRepository<Factura, Long> {
@Query("FROM Factura where clientid = ?1 order by id")
	Page<Factura> fact(Integer clientid, Pageable pageable);
}