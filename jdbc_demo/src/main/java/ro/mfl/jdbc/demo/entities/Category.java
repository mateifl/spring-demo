package ro.mfl.jdbc.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table("Categories")
public class Category implements IdentityOwner {
	@Id
	@Column("CategoryID")
	private Integer id;
	@Column("CategoryName")
	private String name;
	@Column("Description")
	private String description;
}
