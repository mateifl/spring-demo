package ro.mfl.jdbc.demo.entities;

import java.time.LocalDateTime;

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
@Table(value="Orders")
public class Order implements IdentityOwner {
	
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
	@Column("ShipRegion")
	private String shipRegion;
	@Column("ShipPostalCode")
	private String shipPostalCode;
	@Column("ShipCountry")
	private String shipCountry;
}
