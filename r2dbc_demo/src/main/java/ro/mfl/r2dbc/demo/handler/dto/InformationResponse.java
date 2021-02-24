package ro.mfl.r2dbc.demo.handler.dto;

import java.util.List;
import lombok.Data;
import ro.mfl.r2dbc.demo.entities.Category;
import ro.mfl.r2dbc.demo.entities.Customer;
import ro.mfl.r2dbc.demo.entities.Product;


@Data
public class InformationResponse {

  private List<Product> products;
  private List<Category> categories;
  private List<Customer> customers;
  
}
