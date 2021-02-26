package ro.mfl.r2dbc.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ro.mfl.r2dbc.demo.entities.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String
> {

}
