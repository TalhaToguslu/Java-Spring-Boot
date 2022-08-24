package com.talha.northwind.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.entities.concretes.Product;
import com.talha.northwind.entities.dtos.ProductWithCategoryDto;

// Data access katmanı için jpa yapısı, tablo adı ve primary key türü parametre olarak yollanır.
@EnableJpaRepositories
public interface ProductDao extends JpaRepository<Product, Integer> {
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, int categoryId);
	DataResult<List<Product>> getByProductNameOrCategoryCategoryId(String productName, int categoryId);
	DataResult<Product> getByCategoryCategoryIdIn(int[] categoryId);
	DataResult<Product> getByProductNameContaining(String productName);
	
	//@Query("from Product where productName=:productName and category.category_id=:categoryId")
	//Product getByNameAndCategoryCategoryId(String productName, int categoryId);
	
	@Query("Select new com.talha.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName)" +
	" From Category c Left Join c.products p")
	DataResult<List<ProductWithCategoryDto>> getByProductWithCategoryDetails();
}
