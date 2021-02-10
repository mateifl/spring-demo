package ro.mfl.r2dbc.demo.handler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	private Integer productId;
	private Integer quantity;
	private Double unitPrice;
}
