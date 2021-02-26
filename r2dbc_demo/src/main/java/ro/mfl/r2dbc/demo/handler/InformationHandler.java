package ro.mfl.r2dbc.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.r2dbc.demo.entities.Customer;
import ro.mfl.r2dbc.demo.entities.Product;
import ro.mfl.r2dbc.demo.handler.dto.InformationResponse;
import ro.mfl.r2dbc.demo.repositories.CategoryRepository;
import ro.mfl.r2dbc.demo.repositories.CustomerRepository;
import ro.mfl.r2dbc.demo.repositories.ProductRepository;

@RequiredArgsConstructor
@Slf4j
public class InformationHandler {

  private final CategoryRepository categoryRepository;
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;


  public Mono<ServerResponse> getEntities(ServerRequest request) {
    log.info("loading all info entities ");
    Flux<Customer> customers = customerRepository.findAll();
    Flux<Product> products = productRepository.findAll();

    InformationResponse response = new InformationResponse();

    customers.collectList().map(list -> {
      response.setCustomers(list);
      return response;
    });

    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response,
        InformationResponse.class);
  }

}
