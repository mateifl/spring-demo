package ro.mfl.r2dbc.demo.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("Products")
public class Product implements IdentityOwner {
	
	@Id
	@Column("ProductID")
	private Integer id;
	@Column("ProductName")
	private String name;
	@Column("QuantityPerUnit")
	private String quantityPerUnit;
	@Column("UnitPrice")
	private Double unitPrice;
	@Column("UnitsInStock")
	private Integer unitsInStock;
	@Column("UnitsOnOrder")
	private Integer unitsOnOrder;
//	@Column("ReorderLevel")
//	private Integer reorderLevel;
//	@Column("Discontinued")
//	private Boolean discontinued;
	@Column("CategoryID")
	private Integer categoryid;
	@Column("SupplierID")
	private Integer supplierid;
	
}
