package ro.mfl.r2dbc.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ro.mfl.r2dbc.demo.entities.Category;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Integer>  {}
