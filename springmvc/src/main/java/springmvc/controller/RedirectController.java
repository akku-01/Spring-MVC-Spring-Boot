package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

//	1. Using redirect: 
//	@RequestMapping("/one")
//	public String frontController() {
//		System.out.println("this is one function!!!");
//		return "redirect:/two";
//	}
	
//	2.Using RedirectView object
	@RequestMapping("/one")
	public RedirectView frontController() {
		System.out.println("this is one function!!!");
		RedirectView rv = new RedirectView();
		rv.setUrl("two");
		return rv;
	}
	
	
	@RequestMapping("/two")
	public String frontController2() {
		System.out.println("this is second function!!!");
		return "success";
	}

}
