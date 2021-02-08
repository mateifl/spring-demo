package ro.mfl.testclient.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Integer customerId;
	private String companyName;
	private String contactName;
	
}
