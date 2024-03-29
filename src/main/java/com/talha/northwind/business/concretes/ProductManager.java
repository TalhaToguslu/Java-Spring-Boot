package com.talha.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talha.northwind.business.abstracts.ProductService;
import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.core.utilities.result.Result;
import com.talha.northwind.core.utilities.result.SuccessDataResult;
import com.talha.northwind.core.utilities.result.SuccessResult;
import com.talha.northwind.dataAccess.abstarcts.ProductDao;
import com.talha.northwind.entities.concretes.Product;
import com.talha.northwind.entities.dtos.ProductWithCategoryDto;

import lombok.NoArgsConstructor;

// Bu class servis olacak demektir spring'te.
@Service
public class ProductManager implements ProductService{

	@Autowired
	private ProductDao _productDao;
	
	@Override
	public DataResult<List<Product>> GetAll() {
		return new SuccessDataResult<List<Product>>(this._productDao.findAll());
	}

	@Override
	public Result add(Product product) {
		_productDao.save(product);
		return new SuccessResult("Başarılı");
	}
}
