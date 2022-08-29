package com.talha.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.core.utilities.result.Result;
import com.talha.northwind.entities.concretes.Product;
import com.talha.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	Result add(Product product);
	DataResult<List<Product>> GetAll();
}
