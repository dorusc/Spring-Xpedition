package com.doruleanu.Repository;

import com.doruleanu.Entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}