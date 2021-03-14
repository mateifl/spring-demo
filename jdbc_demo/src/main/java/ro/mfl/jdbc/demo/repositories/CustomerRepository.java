package ro.mfl.jdbc.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.mfl.jdbc.demo.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
