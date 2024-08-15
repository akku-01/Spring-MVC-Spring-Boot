package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerIndex {

	@RequestMapping("/index")
	public String frontController() {
		System.out.println("this is index function!!!");
		return "search";
	}
	
	@RequestMapping(path="/searchit",method=RequestMethod.POST)
	public RedirectView frontController2(@RequestParam("query") String query) {
		System.out.println("this is second function!!!");
		RedirectView rv = new RedirectView();
		String str = "https://www.google.com/search?q=" + query;
		rv.setUrl(str);
		return rv;
	}
//	
//
//	public String frontController2(@RequestParam("query") String query) {
//		System.out.println("this is second function!!!");
////		String str = "redirect:/" + "https://www.google.com";
////		return str;
//		return "redirect:/http://www.google.com";
//	}

}
