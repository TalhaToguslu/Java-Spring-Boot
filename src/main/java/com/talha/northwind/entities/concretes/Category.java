package com.talha.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="categories")
@NoArgsConstructor
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "categories") // Burada @JoinColumn yapmadık zaten ID'den gidiyor. category_id
	private List<Product> products;
}
