package ro.mfl.r2dbc.demo.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
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

	public  Mono<ServerResponse> createOrder(ServerRequest serverRequest) {
		if(log.isDebugEnabled()) log.debug("create order");
		Mono<CreateOrderRequest> createOrderRequestMono = serverRequest.body(BodyExtractors.toMono(CreateOrderRequest.class));

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		        .body( createOrderRequestMono.flatMap( this::response ), CreateOrderResponse.class)
		        .onErrorResume( error -> ServerResponse.status(HttpStatus.NOT_FOUND).build() );
	}

	private Mono<CreateOrderResponse> response( CreateOrderRequest request ) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		CreateOrderResponse response = CreateOrderResponse.builder().build();
		return getRepository().save(Order.builder()
				.customerId(request.getCustomerId())
				.orderDate(currentDateTime)
				.employeeId(request.getEmployeeId())
				.shipperId(request.getShipperId())
				.build())
				.log()	
				.map(savedOrder -> {
					if(log.isDebugEnabled()) log.debug(savedOrder.toString());
					response.setOrder(savedOrder);
					Flux.fromIterable(request.getProducts()).flatMap( product -> {
						Mono<OrderDetail> orderDetailMono = orderDetailRepository.save(OrderDetail.builder()
								.productId(product.getProductId())
								.quantity(product.getQuantity())
								.orderId(savedOrder.getId())
								.unitPrice(product.getUnitPrice())
								.build());
						return orderDetailMono;
					}).collectList().subscribe( orderDetails -> response.setOrderDetails(orderDetails) ); 
					return response;
				}).onErrorResume(error -> {
					log.error(error.getMessage());
					return Mono.error( error );
					});
	}
}
