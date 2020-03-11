package com.zensar.springmvcboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.springmvcboot.beans.Product;
import com.zensar.springmvcboot.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;

	public ProductController() {

	}

	@RequestMapping("/")
	public String sayWelcome() {
		System.out.println("sayWelcome");
		//System.out.println(10/0);
		return "home";
	}

	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		return "insertProduct";
	}

	@RequestMapping(value = "/registerProduct",method= {RequestMethod.POST,RequestMethod.GET})
	// public String registerProduct(@RequestParam("productId") int
	// productId,@RequestParam("productName") String
	// productName,@RequestParam("productCost") int productCost,Model model) {

	public String registerProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			return "insertProduct";
		}
		
			Boolean result = service.insertProduct(product);
			
		if (result) {
			return "registerProduct";
			}

		/*
		 * Product product=new Product();
		 * 
		 * product.setProductId(productId); product.setProductName(productName);
		 * product.setProductCost(productCost);
		 * 
		 * model.addAttribute("product", product);
		 */

		return "insertProduct";
	}

	@RequestMapping("/getProduct")
	public String getProduct() {
		return "getProduct";
	}
	
	/*
	 * @RequestMapping("/displayProduct") public String
	 * displayProduct(@RequestParam("productId") int id,Model model) { Product
	 * product=service.getProductById(id); if(product!=null) {
	 * model.addAttribute("product", product); } return "displayProduct"; }
	 */
	
	
	@RequestMapping("/displayProduct")
	public ModelAndView displayProduct(@RequestParam("productId") int id) {
		
		ModelAndView view=new ModelAndView("displayProduct");
		
		
		Product product=service.getProductById(id);
		if(product!=null) {
			//model.addAttribute("product", product);
			view.addObject("product", product);
		}
		return view;
	}
	
	@ModelAttribute
	public void getMessage(Model model) {
		model.addAttribute("myheader", "Product Management");
	}
	
	@ExceptionHandler(value = Exception.class)
	public String somethingGoesWrong() {
		return "error";
	}

}
