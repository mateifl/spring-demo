package ro.mfl.r2dbc.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import ro.mfl.r2dbc.demo.entities.OrderDetail;

public interface OrderDetailRepository extends ReactiveCrudRepository<OrderDetail, Integer> {

}
