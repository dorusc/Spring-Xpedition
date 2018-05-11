package com.doruleanu.Controller;

import com.doruleanu.Entity.Export;
import com.doruleanu.Repository.ExportRepository;
import com.doruleanu.Service.IExportService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api("export")
@RestController
@RequestMapping("/export")
public class ExportController {

	@Autowired
    private ExportRepository exportRepo;
	
	@Autowired
    private IExportService exportService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Export> getExportById(@PathVariable("id") Long id){
    	 Export export =  exportService.getExportById(id);
         return new ResponseEntity<Export>(export, HttpStatus.OK);
    }
       
    @GetMapping (value = "pefactura/{factid}")
    public Page<Export> getAllExportPefactura(@PathVariable("factid") Long factid, Pageable pageable){
        return  exportRepo.findAllByFactura(factid, pageable);
    }
    
    @GetMapping (value = "peproduslafacturi/{id_pr}")
    public Page<Export> getAllExportPeproduct(@PathVariable("id_pr") Long id_pr, Pageable pageable){
        return  exportRepo.findAllByProduct(id_pr, pageable);
    }
   
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void>  deleteExportById(@PathVariable("id") Long id){
        exportService.deleteExportById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}/product/{idprod}/factura/{idfact}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Export> updateExport(@RequestBody Export export,
    		@PathVariable("id") Long id,
    		@PathVariable("idprod") Long idprod,
    		@PathVariable("idfact") Long idfact
    		) {
        exportService.updateExport(id, idprod, idfact, export);
        return new ResponseEntity<Export>(export, HttpStatus.OK);
    }

    @PostMapping(value="/add/{idfact}/{idprod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Export> insertExportNou(@RequestBody Export expfactura,
    		@PathVariable("idfact") Long idfact,
    		@PathVariable("idprod") Long idprod
    		){
    	
        exportService.insertExportNou(idfact, idprod, expfactura);
        return new ResponseEntity<Export>(expfactura, HttpStatus.CREATED);
    }
}