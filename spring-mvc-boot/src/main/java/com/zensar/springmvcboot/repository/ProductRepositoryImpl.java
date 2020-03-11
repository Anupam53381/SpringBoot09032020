package com.zensar.springmvcboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.springmvcboot.beans.Product;
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	List<Product> products;

	public ProductRepositoryImpl() {
		products = new ArrayList<>();
	}

	@Override
	public Boolean insertProduct(Product product) {
		//System.out.println("ram");
		System.out.println(product);
		return products.add(product);

	}

	@Override
	public Product getProductById(int id) {
		
		for( Product product: products) {
			if(product.getProductId()== id) {
				return product;
			}
		}
		
		return null;
	}

}
