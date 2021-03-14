package ro.mfl.r2dbc.demo.handler.dto;

import java.util.List;
import lombok.Data;
import ro.mfl.r2dbc.demo.entities.Category;
import ro.mfl.r2dbc.demo.entities.Customer;
import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.Product;


@Data
public class InformationResponse {

  private List<Product> products;
  private List<Order> orders;
  private List<Customer> customers;
  
}
