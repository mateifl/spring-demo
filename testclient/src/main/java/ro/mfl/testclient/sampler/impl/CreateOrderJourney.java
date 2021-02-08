package ro.mfl.testclient.sampler.impl;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.testclient.entities.Customer;
import ro.mfl.testclient.entities.Order;
import ro.mfl.testclient.entities.OrderDetail;
import ro.mfl.testclient.entities.Product;

public class CreateOrderJourney implements Runnable {

  private WebClient webClient;


  @Override
  public void run() {
	  
	  
//	  Mono<OrderDetail> orderDetail1 = webClient.get().retrieve().bodyToMono(Product.class).map(product -> OrderDetail.builder().productId());
	  
	  
	  
	  Mono<Customer> customerMono = webClient.get().retrieve().bodyToMono(Customer.class);
	  
	  customerMono.map( customer -> {
		 Order order = Order.builder().customerId(customer.getCustomerId()).build();

		 return order;
	  });//.map( order -> order. ); 
	  
  }
}
