package ro.mfl.jdbc.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ro.mfl.jdbc.demo.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {}
