package ro.mfl.jdbc.demo.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("Products")
public class Product implements IdentityOwner {
	
	@Id
	@Column("ProductID")
	private Integer id;
	@Column("ProductName")
	private String name;
	@Column("quantityperunit")
	private String quantityPerUnit;
	@Column("unitprice")
	private Double unitPrice;
	@Column("unitsinstock")
	private Integer unitsInStock;
	@Column("unitsonorder")
	private Integer unitsOnOrder;
	@Column("reorderlevel")
	private Integer reorderLevel;
	@Column("Discontinued")
	private String discontinued;
	@Column("CategoryID")
	private Integer categoryid;
	@Column("SupplierID")
	private Integer supplierid;
	
}
