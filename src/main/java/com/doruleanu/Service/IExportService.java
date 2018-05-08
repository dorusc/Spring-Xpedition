package com.doruleanu.Service;

import com.doruleanu.Entity.Export;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IExportService {
	
	Page<Export> listAllByPage(Pageable pageable);

    Export getExportById(Long id);
    
    void deleteExportById(Long id);

    void updateExport(Export export);

    void insertExportNou(Export export);

	Page<Export> findAllByProduct(Long id_pr, Pageable pageable);

	Page<Export> findAllByFactura(Long factid, Pageable pageable);

}
