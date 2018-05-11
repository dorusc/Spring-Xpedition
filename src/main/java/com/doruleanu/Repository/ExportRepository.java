package com.doruleanu.Repository;

import com.doruleanu.Entity.Export;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExportRepository extends PagingAndSortingRepository<Export, Long> {

	@Query("select e FROM Export e where factura.id = ?1 order by id")
	Page<Export> findAllByFactura(Long factid, Pageable pageable);

	@Query("select e FROM Export e where product.id = ?1 order by id")
	Page<Export> findAllByProduct(Long id_pr, Pageable pageable);

}