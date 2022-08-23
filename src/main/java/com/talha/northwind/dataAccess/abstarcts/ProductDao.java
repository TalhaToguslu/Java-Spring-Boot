package com.talha.northwind.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talha.northwind.entities.concretes.Product;

// Data access katmanı için jpa yapısı, tablo adı ve primary key türü parametre olarak yollanır.
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	Product getByCategoryIdIn(int[] categoryId);
	Product getByProductNameContain(String productName);
	
	@Query("from Product where productName=:productName and category.category_id=:categoryId")
	Product getByNameAndCategory_CategoryId(String productName, int categoryId);
}
