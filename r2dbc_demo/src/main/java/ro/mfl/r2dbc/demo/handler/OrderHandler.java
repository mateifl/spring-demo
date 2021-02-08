package ro.mfl.r2dbc.demo.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import ro.mfl.r2dbc.demo.entities.Customer;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.Product;
import ro.mfl.r2dbc.demo.entities.Shipper;
import ro.mfl.r2dbc.demo.repositories.OrderRepository;

@Component
public class OrderHandler extends AbstractHandler<Integer, Order, OrderRepository>{

  private final static Order orderPrototype = new Order();
	
  public OrderHandler(OrderRepository repository) {
    super(repository);
  }

  @Override protected Order prototype(){
	  return orderPrototype;
  }

  public void createOrder(Customer customer, List<Product> products, Shipper shipper) {

  }

}
