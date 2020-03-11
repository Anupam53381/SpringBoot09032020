package com.zensar.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entites.Product;

@RestController
public class WelcomeController {

	/*
	 * List<Product> products = Arrays.asList(new Product(1, "Pen", 200), new
	 * Product(2, "Mobile", 20000), new Product(3, "HDD", 2000));
	 */
	
	List<Product> products = new ArrayList<Product>();

	@RequestMapping("/")
	public String welcome() {
		return "<h2> Welcome </h2>";
	}

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
