package com.zensar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entites.Product;
import com.zensar.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService impl;

	@RequestMapping(value = "/products", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public Iterable<Product> getAllProducts() {
		return impl.getAllProducts();
	}

	@RequestMapping("/products/{productId}")
	public Product getProduct(@PathVariable(value = "productId", required = false) int productId) {
		return impl.getProduct(productId);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		impl.insertProduct(product);
	}

}
