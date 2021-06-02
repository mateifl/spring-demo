package ro.mfl.r2dbc.demo.handler.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import ro.mfl.r2dbc.demo.entities.Order;
import ro.mfl.r2dbc.demo.entities.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationResponse {

  private List<Product> products;
  private List<Order> orders;

}
