package ro.mfl.testclient.journey.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import ro.mfl.testclient.entities.Product;
import ro.mfl.testclient.journey.Journey;
import ro.mfl.testclient.journey.Result;

@Component("loadProductsJourney")
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class LoadProductsJourney implements Journey<Flux<Product>> {

  private final WebClient webClient;

  @Override
  public Result<Flux<Product>> execute() {
    if(log.isDebugEnabled()) log.debug("load all products");
    Flux<Product> productFlux =  webClient.get().uri("products").retrieve().bodyToFlux(Product.class);
    return new Result<>(productFlux);
  }
}

