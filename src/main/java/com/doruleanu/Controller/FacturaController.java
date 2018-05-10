package com.doruleanu.Controller;

import com.doruleanu.Entity.Client;
import com.doruleanu.Entity.Factura;
import com.doruleanu.Repository.FacturaRepository;
import com.doruleanu.Service.IFacturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/facturi")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepo;
    
    @Autowired
    private IFacturaService facturaService;
    
// ok
    @GetMapping
    public Page<Factura> list( Pageable pageable){
		return facturaRepo.findAll(pageable);
	} 
    
// ok
   @GetMapping(value = "/getbyid/{id}")
   public ResponseEntity<Factura> findById(@PathVariable("id") Long id){
   		return new ResponseEntity<Factura>(facturaService.getFacturaById(id), HttpStatus.OK);
    }

// ok
   @GetMapping(value = "/getbyclientid/{clientid}")
   public Page<Factura> getFacturaByClientId(@PathVariable("clientid") Integer clientid, Pageable pageable){
       return facturaRepo.factura(clientid, pageable);
   }

// ok
   @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> removeFacturaById(@PathVariable("id") Long id){
    	 facturaService.removeFacturaById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}/client/{clientid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> updateFactura(@RequestBody Factura factura,
    		@PathVariable("clientid") Integer clientid,
    		@PathVariable("id") Long id) {
        facturaService.updateFactura(id, clientid, factura);
        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
    }

    @PostMapping(
    		value = "/client/{clientid}", 
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> insertFacturaNoua(
    		@RequestBody Factura factura,
    		@PathVariable("clientid") Integer clientid)
    		{
    	facturaService.insertFacturaNoua(clientid, factura);
        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
    }
}
