package net.codejava.product.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/")
	public List<Product> list(){
		return productRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody @Valid Product product){
		Product savedProduct = productRepo.save(product);
		URI productURI = URI.create("/products" + savedProduct.getId());
		return ResponseEntity.created(productURI).body(savedProduct);
	}
	

}
