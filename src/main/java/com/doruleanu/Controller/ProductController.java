package com.doruleanu.Controller;

import com.doruleanu.Entity.Product;
import com.doruleanu.Repository.ProductRepository;
import com.doruleanu.Service.IProductService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("product")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductRepository productRepo;
	
    @Autowired
    IProductService productService;

    @GetMapping
    public Page<Product> list( int page, int size){
    	PageRequest pageRequest = PageRequest.of(page, size);
		return productRepo.findAll(pageRequest);
	} 

    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
    	Product produ = productService.getProductById(id);
        return new ResponseEntity<Product>(produ, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getbycod/{prodid}")
    public Page<Product> getProductByCod(@PathVariable("prodid") String prodid, int page, int size){
    	PageRequest pageRequest = PageRequest.of(page, size);
    	return productRepo.product1(prodid, pageRequest);
    }
    
    @GetMapping(value = "/getbyname/{name}")
    public Page<Product> getProductByName(@PathVariable("name") String name, int page, int size){
    	PageRequest pageRequest = PageRequest.of(page, size);
    	return productRepo.product2(name, pageRequest);
    }    

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void>  deleteProductById(@PathVariable("id") Long id){
        productService.removeProductById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> insertProductNou(@RequestBody Product product){
        productService.insertProductNou(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

}
