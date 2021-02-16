package ro.mfl.r2dbc.demo.handler.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderRequest {

  private List<ProductDto> products;
  private String customerId;
  private Integer shipperId;
  private Integer employeeId;
  private Timestamp requiredDate;
  
}
