package ro.mfl.testclient.journey.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;

@Component
@Scope("prototype")
@AllArgsConstructor
public class LoadProductsJourney implements Journey {
  @Autowired
  private final WebClient webClient;

  @Override
  public void execute() {
    Flux<Product> productFlux =  webClient.get().uri("products").retrieve().bodyToFlux(Product.class);

  }
}

