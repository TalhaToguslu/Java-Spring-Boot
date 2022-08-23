package com.talha.northwind.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talha.northwind.entities.concretes.Product;

// Data access katmanı için jpa yapısı, tablo adı ve primary key türü parametre olarak yollanır.
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);
	Product getByProductNameAndCategoryCategoryId(String productName, int categoryId);
	List<Product> getByProductNameOrCategoryCategoryId(String productName, int categoryId);
	Product getByCategoryCategoryIdIn(int[] categoryId);
	Product getByProductNameContaining(String productName);
	
	//@Query("from Product where productName=:productName and category.category_id=:categoryId")
	//Product getByNameAndCategoryCategoryId(String productName, int categoryId);
}
