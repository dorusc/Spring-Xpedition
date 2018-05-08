package com.doruleanu.Controller;

import com.doruleanu.Entity.Product;
import com.doruleanu.Service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public Page<Product> list( Pageable pageable){
		Page<Product> Products = productService.listAllByPage(pageable);
		return Products;
	} 

    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
    	Product produ = productService.getProductById(id);
        return new ResponseEntity<Product>(produ, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getbycod/{prodid}")
    public Page<Product> getProductByCod(@PathVariable("prodid") String prodid, Pageable pageable){
    	Page<Product> produse = productService.getProductByCod(prodid, pageable);
        return produse;
    }
    
    @GetMapping(value = "/getbyname/{name}")
    public Page<Product> getProductByName(@PathVariable("name") String name, Pageable pageable){
    	Page<Product> produse = productService.getProductByName(name, pageable);
        return produse;
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
