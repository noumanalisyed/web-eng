package com.techno.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Value("#{dataOptions}")
    private Map<String, String> categoryOptions;
    
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Product theProduct = new Product();
		
		// add student object to the model
		theModel.addAttribute("product", theProduct);
	
	    // add the country options to the model 
	    theModel.addAttribute("theCategoryOptions", categoryOptions);
	    
		return "product-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("product") Product theProduct) {
		
		// log the input data
		System.out.println("The Product: " + theProduct.getName()
							+ " " + theProduct.getCategory());
		
		return "product-confirmation";
	}
	
}









