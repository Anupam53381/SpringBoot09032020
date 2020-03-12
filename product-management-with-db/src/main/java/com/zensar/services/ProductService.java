package com.zensar.services;

import java.util.List;

import com.zensar.entites.Product;

public interface ProductService {
	
	public Iterable<Product> getAllProducts() ;

	public Product getProduct(int productId) ;
	
	public void insertProduct(Product product) ;


}
