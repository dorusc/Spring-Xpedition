package com.doruleanu.Controller;

import com.doruleanu.Entity.Factura;
import com.doruleanu.Repository.FacturaRepository;
import com.doruleanu.Service.IClientService;
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

    @GetMapping
    public Page<Factura> list( Pageable pageable){
		Page<Factura> facturi = facturaService.listAllByPage(pageable);
		return facturi;
	} 
    
   @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable("id") Long id){
    	Factura factura = facturaService.getFacturaById(id);
        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
    }
   
   @GetMapping(value = "/getbyclientid/{clientid}")
   public Page<Factura> getFacturaByClientId(@PathVariable("clientid") Integer clientid, Pageable pageable){
       return facturaRepo.findAll(pageable);
   }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> removeFacturaById(@PathVariable("id") Long id){
        facturaService.removeFacturaById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> updateFactura(@RequestBody Factura factura) {
        facturaService.updateFactura(factura);
        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> insertFacturaNoua(@RequestBody Factura factura){
        facturaService.insertFacturaNoua(factura);
        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
    }
}
