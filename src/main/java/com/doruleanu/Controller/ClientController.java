package com.doruleanu.Controller;

import com.doruleanu.Entity.Client;
import com.doruleanu.Repository.ClientRepository;
import com.doruleanu.Service.IClientService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.Collections;

@Api("client")

@RestController
@RequestMapping("/clienti")
public class ClientController {

	@Autowired
    private ClientRepository clientRepo;
	
    @Autowired
    private IClientService clientService;

    @GetMapping
    public Page<Client> list(int page, int size){
    	PageRequest pageRequest = PageRequest.of(page, size);
    	return clientRepo.findAll(pageRequest);
	} 

    
    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id){
    	Client client = clientService.getClientById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
 
    @GetMapping(value = "/getbyname/{nume}")
    public Page<Client> getClientByName(@PathVariable("nume") String nume, int page, int size){
    	PageRequest pageRequest = PageRequest.of(page, size);
    	return clientRepo.client(nume, pageRequest);
      
    }
       

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void>  deleteClientById(@PathVariable("id") Integer id){
        clientService.removeClientById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> insertClientNou(@RequestBody Client client){
        clientService.insertClientNou(client);
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }
}
