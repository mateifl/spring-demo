package ro.mfl.r2dbc.demo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(value="Orders")
public class Order {
	
	@Id
	@Column("OrderID")
	private Integer id;
	@Column("OrderDate")
	private LocalDateTime orderDate;
	@Column("RequiredDate")
	private LocalDateTime requiredDate;
	@Column("ShippedDate")
	private LocalDateTime shippedDate;
	@Column("Freight")
	private Double freight;
	@Column("ShipName")
	private String shipName;
	@Column("ShipAddress")
	private String shipAddress;
	@Column("ShipCity")
	private String shipCity;
	@Column("ShipVia")
	private Integer shipperId;
	private String shipRegion;
	@Column("ShipPostalCode")
	private String shipPostalCode;
	@Column("ShipCountry")
	private String shipCountry;
	@Column("CustomerID")
	private String customerId;
	@Column("EmployeeID")
	private Integer employeeId;
	
}
