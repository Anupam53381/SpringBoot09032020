package com.zensar.springmvcboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springmvcboot.beans.Product;
import com.zensar.springmvcboot.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Boolean insertProduct(Product product) {
		//System.out.println("seeta");
		return repository.insertProduct(product);
		
	}

	@Override
	public Product getProductById(int id) {
		
		return repository.getProductById(id);
	}

}
