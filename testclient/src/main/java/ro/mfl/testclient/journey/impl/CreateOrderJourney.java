package ro.mfl.testclient.journey.impl;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.testclient.entities.Customer;
import ro.mfl.testclient.entities.Order;
import ro.mfl.testclient.entities.OrderDetail;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;

public class CreateOrderJourney implements Journey {

  private WebClient webClient;


  @Override
  public void execute() {
	  Mono<Customer> customerMono = webClient.get().retrieve().bodyToMono(Customer.class);
	  customerMono.map( customer ->  Order.builder().customerId(customer.getCustomerId()).build());//.map( order -> order. );
	  
  }
}
