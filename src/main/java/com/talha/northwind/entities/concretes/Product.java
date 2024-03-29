package com.talha.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {	
	
	//ID'yi belirtmen lazım.
	@Id
	// GeneratedValue, otomatik olarak +1 olarak artacağını belirtir.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	//@Column(name="category_id")
	//private int categoryId;
	
	@Column(name="product_name")
	@NotBlank //"" böyle gelmesin.
	@NotNull
	private String productName;
	
	@Column(name="unit_price")
	@NotNull
	private double unitPrice;
	
	@Column(name="units_in_stock")
	@NotNull
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	@NotBlank //"" böyle gelmesin.
	@NotNull
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name= "category_id")
	@NotNull
	private Category category;
}
