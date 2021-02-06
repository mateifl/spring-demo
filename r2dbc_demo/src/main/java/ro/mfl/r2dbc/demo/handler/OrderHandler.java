package ro.mfl.r2dbc.demo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.repositories.OrderRepository;

@Component
public class OrderHandler extends AbstractHandler<Integer, Order, OrderRepository>{

  private final static Order orderPrototype = new Order();
	
  public OrderHandler(OrderRepository repository) {
    super(repository);
  }

//  public Mono<ServerResponse> getCompleteOrder(ServerRequest request) {
//	  final Integer id = Integer.valueOf(request.pathVariable("id"));
//	  Mono<Order> orderMono = getRepository().findById(id).flatMap( order -> {
//		  order.getId();
//	  });
//  }

  @Override protected Order prototype(){
	  return orderPrototype;
  }
}
