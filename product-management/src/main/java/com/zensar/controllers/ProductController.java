package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entites.Product;
@RestController
public class ProductController {
	
	List<Product> products = new ArrayList<Product>();
	
	@RequestMapping(value = "/products", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		System.out.println("Ram");
		return products;

	}

	// http://localhost:8080/products/{3}

	/*
	 * @RequestMapping("/products/{productId}") public Product
	 * getProduct(@PathVariable ("productId")int productId) {
	 * 
	 * for (Product product : products) { if (product.getProductId() == productId) {
	 * return product; }
	 * 
	 * } return null; }
	 */

	@RequestMapping("/products/{productId}")
	public List<Product> getProduct(@PathVariable(value = "productId", required = false) int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				List<Product> availableProduct = new ArrayList<>();
				availableProduct.add(product);
				return availableProduct;
			}
		}
		return products;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		products.add(product);
	}


}
