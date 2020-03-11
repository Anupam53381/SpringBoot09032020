package com.zensar.springmvcboot.services;

import org.springframework.stereotype.Service;

import com.zensar.springmvcboot.beans.Product;

@Service
public interface ProductService {

	public Boolean insertProduct(Product product);

	public Product getProductById(int id);

}
