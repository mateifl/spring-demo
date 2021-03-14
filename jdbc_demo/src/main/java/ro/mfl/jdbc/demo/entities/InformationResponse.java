package ro.mfl.jdbc.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationResponse {

    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

}
