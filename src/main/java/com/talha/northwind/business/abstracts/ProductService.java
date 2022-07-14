package com.talha.northwind.business.abstracts;

import java.util.List;
import com.talha.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> GetAll();
}
