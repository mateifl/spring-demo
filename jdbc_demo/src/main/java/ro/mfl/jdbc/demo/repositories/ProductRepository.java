package ro.mfl.jdbc.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.mfl.jdbc.demo.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {}
