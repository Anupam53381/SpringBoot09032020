package com.zensar.springmvcboot.repository;

import org.springframework.stereotype.Repository;

import com.zensar.springmvcboot.beans.Product;

@Repository
public interface ProductRepository {
		
	public Boolean insertProduct(Product product);

	public Product getProductById(int id);
}
