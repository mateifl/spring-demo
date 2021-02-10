package ro.mfl.testclient.journey.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.testclient.entities.Customer;
import ro.mfl.testclient.entities.Order;
import ro.mfl.testclient.entities.OrderDetail;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;
import ro.mfl.testclient.journey.Result;

public class CreateOrderJourney implements Journey<Order> {

  @Autowired
  private WebClient webClient;

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
