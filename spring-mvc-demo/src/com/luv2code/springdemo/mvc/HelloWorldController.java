package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// controller method to show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from the html form
		String theName = request.getParameter("studentName");

		// convert data to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";

	}

	// controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionThree")
	// Binding request params -> @RequestParam("studentName") String theName
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

		// convert data to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey my friend! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";

	}
}
