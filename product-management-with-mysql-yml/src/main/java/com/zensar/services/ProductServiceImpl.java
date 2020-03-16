package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entites.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository;

	List<Product> products = new ArrayList<Product>();

	@Override
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(int productId) {

		return repository.findById(productId).get();
	}

	@Override
	public void insertProduct(Product product) {
		repository.save(product);

	}

}
