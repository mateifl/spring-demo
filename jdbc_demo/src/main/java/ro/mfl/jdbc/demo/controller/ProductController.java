package ro.mfl.jdbc.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.mfl.jdbc.demo.entities.Product;
import ro.mfl.jdbc.demo.repositories.ProductRepository;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {
	private final ProductRepository productRepository;
	
	  @GetMapping("/products")
	  public ResponseEntity<?> getEntities() {
	    log.info("loading products");
	    List<Product> entities = StreamSupport.stream(productRepository.findAll().spliterator(), false)
	        .collect(Collectors.toList());
	    return new ResponseEntity<>(entities, HttpStatus.OK);
	  }
	
}
