package ro.mfl.r2dbc.demo.handler.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.OrderDetail;

@Data
public class CreateOrderResponse {
	private Order order;
	private List<OrderDetail> orderDetails = new ArrayList<>();
	public void addOrderDetail(OrderDetail orderDetail) {
	  orderDetails.add(orderDetail);
	}
	
}
