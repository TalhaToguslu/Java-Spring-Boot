package com.talha.northwind.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talha.northwind.entities.concretes.Product;

// Data access katmanı için jpa yapısı, tablo adı ve primary key türü
public interface ProductDao extends JpaRepository<Product, Integer> {

}
