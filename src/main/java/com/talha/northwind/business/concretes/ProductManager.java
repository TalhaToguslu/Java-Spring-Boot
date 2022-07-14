package com.talha.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talha.northwind.business.abstracts.ProductService;
import com.talha.northwind.dataAccess.abstarcts.ProductDao;
import com.talha.northwind.entities.concretes.Product;

// Bu class servis olacak demektir spring'te.
@Service
public class ProductManager implements ProductService{

	private ProductDao _productDao;
	
	// Autowired, direkt productDao'ya karşılık gelecek bir instance oluşturur.
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		_productDao = productDao;
	}
	
	@Override
	public List<Product> GetAll() {
		return this._productDao.findAll();
	}

}
