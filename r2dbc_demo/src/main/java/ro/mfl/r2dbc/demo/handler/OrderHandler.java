package ro.mfl.r2dbc.demo.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.OrderDetail;
import ro.mfl.r2dbc.demo.handler.dto.CreateOrderRequest;
import ro.mfl.r2dbc.demo.handler.dto.CreateOrderResponse;
import ro.mfl.r2dbc.demo.repositories.OrderDetailRepository;
import ro.mfl.r2dbc.demo.repositories.OrderRepository;

@Component
@Slf4j
public class OrderHandler extends AbstractHandler<Integer, Order, OrderRepository> {

	private final OrderDetailRepository orderDetailRepository;
	private final static Order orderPrototype = new Order();

	public OrderHandler(OrderRepository repository, OrderDetailRepository orderDetailRepository) {
		super(repository);
		this.orderDetailRepository = orderDetailRepository;
	}

	@Override
	protected Order prototype() {
		return orderPrototype;
	}

	public Mono<ServerResponse> createOrder(ServerRequest serverRequest) {
		if (log.isDebugEnabled())
			log.debug("create order");
		Mono<CreateOrderRequest> createOrderRequestMono = serverRequest
				.body(BodyExtractors.toMono(CreateOrderRequest.class));

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(createOrderRequestMono.flatMap(this::response), CreateOrderResponse.class)
				.onErrorResume(error -> ServerResponse.status(HttpStatus.NOT_FOUND).build());
	}

	private Mono<CreateOrderResponse> response(CreateOrderRequest request) {
		log.debug("create response");
		LocalDateTime currentDateTime = LocalDateTime.now();
		CreateOrderResponse response = new CreateOrderResponse();
		return getRepository()
				.save(Order.builder().customerId(request.getCustomerId()).orderDate(currentDateTime)
						.employeeId(request.getEmployeeId()).shipperId(request.getShipperId()).build())
				.log()
				.map(savedOrder -> {
					if (log.isDebugEnabled())
						log.debug(savedOrder.toString());
					response.setOrder(savedOrder);
					return response;
				})
				.flatMap(r -> {
				  List<OrderDetail> orderDetails = request.getProducts().stream().map( product -> OrderDetail.builder()
                      .productId(product.getProductId())
                      .quantity(product.getQuantity())
                      .orderId(r.getOrder().getId())
                      .unitPrice(product.getUnitPrice())
                      .build() ).collect(Collectors.toList());
				  
				     return orderDetailRepository.saveAll(orderDetails).collectList().map( l -> {
				       r.setOrderDetails(l);
				       return r;
				     });
				  
				})
				.onErrorResume(error -> {
					log.error(error.getMessage());
					return Mono.error(error);
				});
	}
}
