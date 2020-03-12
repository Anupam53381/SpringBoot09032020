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
	
	

	@RequestMapping("/")
	public String welcome() {
		return "<h2> Welcome </h2>";
	}

	
}
