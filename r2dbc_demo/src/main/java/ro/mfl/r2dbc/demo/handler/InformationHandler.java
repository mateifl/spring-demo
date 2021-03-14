package ro.mfl.r2dbc.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.mfl.r2dbc.demo.entities.Customer;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.Product;
import ro.mfl.r2dbc.demo.handler.dto.InformationResponse;
import ro.mfl.r2dbc.demo.repositories.CategoryRepository;
import ro.mfl.r2dbc.demo.repositories.CustomerRepository;
import ro.mfl.r2dbc.demo.repositories.OrderRepository;
import ro.mfl.r2dbc.demo.repositories.ProductRepository;

@RequiredArgsConstructor
@Slf4j
@Component
public class InformationHandler {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public Mono<ServerResponse> getEntities(ServerRequest request) {
        log.info("loading all info entities ");
        Flux<Customer> customers = customerRepository.findAll();
        Flux<Product> products = productRepository.findAll();
        Flux<Order> orders = orderRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response(customers, products, orders),
                InformationResponse.class);
    }

    private Mono<InformationResponse> response(Flux<Customer> customers, Flux<Product> products, Flux<Order> orders) {
        Mono<InformationResponse> response = Mono.just(new InformationResponse());
        return response.flatMap(r ->
                customers.collectList().map(list -> {
                    r.setCustomers(list);
                    return r;
                }))
                .flatMap(r ->
                        products.collectList().map(list -> {
                            r.setProducts(list);
                            return r;
                        }))
                .flatMap(r ->
                        orders.collectList().map(list -> {
                            r.setOrders(list);
                            return r;
                        }));

//     return       customers.collectList().map(list -> {
//      response.setCustomers(list);
//      return response;
//    });
//    .map(r1 -> products.collectList().map(l -> {
//      r1.setProducts(l);
//      return r1;
//    } ));

    }
}
