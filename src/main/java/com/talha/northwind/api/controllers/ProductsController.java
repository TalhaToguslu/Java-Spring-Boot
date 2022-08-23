package com.talha.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talha.northwind.business.abstracts.ProductService;
import com.talha.northwind.entities.concretes.Product;
// Result yapısı eklendi.
// Kontroller olduğunu belirttik. Ve Yolunu belirttik.
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService _productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this._productService = productService;
	}

	@GetMapping("/getall")
	public List<Product> getAll(){
		return this._productService.GetAll();
	}
}
