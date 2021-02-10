package ro.mfl.r2dbc.demo.handler.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.OrderDetail;

@Data
@Builder
public class CreateOrderResponse {
	private Order order;
	private List<OrderDetail> orderDetails; 
}
