package ro.mfl.jdbc.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import ro.mfl.jdbc.demo.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {}
