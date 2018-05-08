package com.doruleanu.Repository;

import com.doruleanu.Entity.Export;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExportRepository extends PagingAndSortingRepository<Export, Long> {

}