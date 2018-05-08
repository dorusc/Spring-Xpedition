package com.doruleanu.Controller;

import com.doruleanu.Entity.Export;
import com.doruleanu.Service.IExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private IExportService exportService;

    @GetMapping
    public Page<Export> list( Pageable pageable){
		Page<Export> exporturi = exportService.listAllByPage(pageable);
		return exporturi;
	} 

    @GetMapping(value = "/{id}")
    public ResponseEntity<Export> getExportById(@PathVariable("id") Long id){
    	 Export export =  exportService.getExportById(id);
         return new ResponseEntity<Export>(export, HttpStatus.OK);
    }
       
    @GetMapping (value = "pefactura/{factid}")
    public Page<Export> getAllExportPefactura(@PathVariable("factid") Long factid, Pageable pageable){
        Page<Export> list =  exportService.findAllByFactura(factid, pageable);
        return list;
    }
    
    @GetMapping (value = "peprodus/{id_pr}")
    public Page<Export> getAllExportPeproduct(@PathVariable("id_pr") Long id_pr, Pageable pageable){
        Page<Export> list =  exportService.findAllByProduct(id_pr, pageable);
        return list;
    }
   
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>  removeExportById(@PathVariable("id") Long id){
        exportService.deleteExportById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Export> updateExport(@RequestBody Export factura) {
        exportService.updateExport(factura);
        return new ResponseEntity<Export>(factura, HttpStatus.OK);
    }

    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Export> insertExportNou(@RequestBody Export expfactura){
        exportService.insertExportNou(expfactura);
        return new ResponseEntity<Export>(expfactura, HttpStatus.CREATED);
    }
}