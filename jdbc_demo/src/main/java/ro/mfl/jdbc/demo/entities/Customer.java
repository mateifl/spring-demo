package ro.mfl.jdbc.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table(value="Customers")
public class Customer {
    @Id
    @Column("CustomerID")
    private String customerId;
    @Column("CompanyName")
    private String companyName;
    @Column("ContactName")
    private String contactName;
    @Column("ContactTitle")
    private String contactTitle;
    @Column("City")
    private String city;
    @Column("PostalCode")
    private String postalCode;
    @Column("Country")
    private String country;

}
