package ro.mfl.testclient.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
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