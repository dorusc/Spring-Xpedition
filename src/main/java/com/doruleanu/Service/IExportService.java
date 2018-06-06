package com.doruleanu.Service;

import com.doruleanu.Entity.Export;


public interface IExportService {
	
    Export getExportById(Long id);
    
    void deleteExportById(Long id);

    void insertExportNou(Long idfact, Long idprod, Export export);

	void updateExport(Long id, Long idprod, Long idfact, Export export);

}
