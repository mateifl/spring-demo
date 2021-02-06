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
import ro.mfl.jdbc.demo.entities.Order;
import ro.mfl.jdbc.demo.repositories.OrderRepository;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
	
	  private final OrderRepository orderRepository;

	  @GetMapping("/orders")
	  public ResponseEntity<?> getEntities() {
	    log.info("loading orders");
	    List<Order> entities = StreamSupport.stream(orderRepository.findAll().spliterator(), false)
	        .collect(Collectors.toList());
	    return new ResponseEntity<>(entities, HttpStatus.OK);
	  }
}
