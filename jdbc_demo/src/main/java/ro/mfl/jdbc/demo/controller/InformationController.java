package ro.mfl.jdbc.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mfl.jdbc.demo.entities.Customer;
import ro.mfl.jdbc.demo.entities.InformationResponse;
import ro.mfl.jdbc.demo.entities.Order;
import ro.mfl.jdbc.demo.entities.Product;
import ro.mfl.jdbc.demo.repositories.CustomerRepository;
import ro.mfl.jdbc.demo.repositories.OrderRepository;
import ro.mfl.jdbc.demo.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InformationController {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/info")
    public ResponseEntity<?> response() {
        log.info("load information");
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return new ResponseEntity<>(new InformationResponse(customers, products, orders), HttpStatus.OK);
    }
}
