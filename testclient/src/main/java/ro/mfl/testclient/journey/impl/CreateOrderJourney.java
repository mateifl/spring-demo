package ro.mfl.testclient.journey.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import ro.mfl.testclient.entities.Customer;
import ro.mfl.testclient.entities.Order;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;
import ro.mfl.testclient.journey.Result;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class CreateOrderJourney implements Journey<Order> {

  
  private final WebClient webClient;

  @Override
  public Result<Order> execute() {
	  Mono<Customer> customerMono = webClient.get().uri("customers").retrieve().bodyToMono(Customer.class);
	  Mono<Product> product1Mono = webClient.get().uri("products").retrieve().bodyToMono(Product.class);
//      Mono<Product> product2Mono = webClient.get().uri("products").retrieve().bodyToMono(Product.class);//.map(product -> {
//          product.set
//      });
	  customerMono.map( customer ->  Order.builder().customerId(customer.getCustomerId()).build());//.map( order -> order. );
      Order order = new Order();
	  return new Result<>(order);
  }

}
