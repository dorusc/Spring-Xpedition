package com.doruleanu.Repository;

import com.doruleanu.Entity.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

	Page<Client> findAll(Pageable pageable);
	
	@Query("select c FROM Client c where nume like concat('%',:nume, '%') order by nume")
	Page<Client> client(@Param("nume") String nume, Pageable pageable);


}