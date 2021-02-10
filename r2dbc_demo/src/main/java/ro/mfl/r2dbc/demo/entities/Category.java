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
@Table("Categories")
public class Category  {
	
	@Id
	@Column("CategoryID")
	private Integer id;
	@Column("CategoryName")
	private String name;
	@Column("Description")
	private String description;
	
}
