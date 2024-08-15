package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.dao.ProductDao;
import springmvc.model.Product;

@Controller
public class CrudController {
	@Autowired
	private ProductDao prod;
	
	@RequestMapping("crud")
	public String handler(Model m) {
		m.addAttribute("title","add Product");
		return "crud_index1";
	}
	
	@RequestMapping("/add-product")
	public String addProduct() {
		return "crud_add_form";
	}
	
	@RequestMapping(value="/form_handler",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product
			,HttpServletRequest request) {
		System.out.println("this is one function!!!");
		System.out.println(product);
		//Step below is to send data to database
		prod.createProd(product);
		RedirectView rv = new RedirectView();
		rv.setUrl( request.getContextPath()+"/");
		return rv;
	}
	
}
