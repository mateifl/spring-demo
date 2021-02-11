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
@Table(value="order_details")
public class OrderDetail {
	
	@Id
	@Column("id")
	private Integer id;
	@Column("OrderID")
	private Integer orderId;
	@Column("ProductID")
	private Integer productId;
	@Column("UnitPrice")
	private Double unitPrice;
	@Column("Quantity")
	private Integer quantity;
}
