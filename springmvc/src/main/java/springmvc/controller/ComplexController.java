package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.UserComplex;
import springmvc.service.ComplexService;
import springmvc.service.UserService;

@Controller
public class ComplexController {

//	@Autowired
//	private ComplexService userService;
	
	 @RequestMapping("/complex")
	 public String handler() {
		 return "complex";
	 }
	 
	 @RequestMapping(path="/handle",method=RequestMethod.POST)
	 public String handler2(@ModelAttribute("usercomplex") UserComplex usercomplex,BindingResult result) {
		 if(result.hasErrors()) {
			 return "complex";
		 }
		 
		 System.out.println(usercomplex);
//		 this.userService.createUser(usercomplex);
		 return "ommk";
	 }

}
