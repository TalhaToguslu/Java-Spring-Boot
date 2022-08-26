package com.talha.northwind.dataAccess.abstarcts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.entities.concretes.Product;
import com.talha.northwind.entities.dtos.ProductWithCategoryDto;

// Data access katmanı için jpa yapısı, tablo adı ve primary key türü parametre olarak yollanır.
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);
	Product getByProductNameAndCategoryCategoryId(String productName, int categoryId);
	Product getByProductNameOrCategoryCategoryId(String productName, int categoryId);
	Product getByCategoryCategoryIdIn(int[] categoryId);
	Product getByProductNameContaining(String productName);
	
	//@Query("from Product where productName=:productName and category.category_id=:categoryId")
	//Product getByNameAndCategoryCategoryId(String productName, int categoryId);
	
	@Query("Select new com.talha.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName)" +
	" From Category c Left Join c.products p")
	List<ProductWithCategoryDto> getByProductWithCategoryDetails();
}
