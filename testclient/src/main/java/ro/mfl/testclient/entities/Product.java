package ro.mfl.testclient.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Integer id;
	private String name;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
//	private Integer reorderLevel;
//	private Boolean discontinued;
	private Integer categoryid;
	private Integer supplierid;
	
}