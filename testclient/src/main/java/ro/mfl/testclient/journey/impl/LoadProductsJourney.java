package ro.mfl.testclient.journey.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;
import ro.mfl.testclient.journey.Result;

import java.util.List;

@Component
@Scope("prototype")
@AllArgsConstructor
@Slf4j
public class LoadProductsJourney implements Journey {

  private final WebClient webClient;


  @Override
  public Result<List<Product>> execute() {
    if(log.isTraceEnabled()) log.trace("load all products");
    Flux<Product> productFlux =  webClient.get().uri("products").retrieve().bodyToFlux(Product.class);
    return new Result<>(productFlux.buffer().blockLast());
  }



}

