package ro.mfl.r2dbc.demo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
