package springmvc.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class homeController {
	
	@Autowired
	private UserService userService;
	
	
	//-------using @ModelAttribute for common data display------
	@ModelAttribute
	public void commonData(Model m) {
		m.addAttribute("heading", "This is good bro!");
		m.addAttribute("desc", "This is good description bro!!!!");
	}
	
//	******sending data from controller to view***************
//	--------using Model 
	
//	public String home(Model model) {
//		System.out.println("ahtiuseh");
//		model.addAttribute("name", "Shivansh Dixit");
//		List<String> lst = new ArrayList<String>();
//		lst.add("jklfsd");
//		lst.add("jklfa");
//		lst.add("jkl;fasd");
//		lst.add("jklasdf");
//		model.addAttribute("liist",lst); 
//		return "index";
//	}
	
	
//	---------------using ModelAndView
	@RequestMapping(path="/home",method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("ahtiuseh");
		ModelAndView model = new ModelAndView();
		model.addObject("name", "Shivansh Dixit");
		List<String> lst = new ArrayList<String>();
		lst.add("jklfsd");
		lst.add("jklfa");
		lst.add("jkl;fasd");
		lst.add("jklasdf");
		model.addObject("liist",lst);
		model.setViewName("index");
		return model;
	}
	@RequestMapping(path="/about",method=RequestMethod.GET)
	public ModelAndView about() {
		System.out.println("asfd this is about");
		ModelAndView model = new ModelAndView();
		model.setViewName("about");
		return model;
	}
	
//	***********sending data from view to controller and returning back to view**********
	
	
	
	
//	----------using servlet Https request method-----------
//	public String handleForm(HttpServletRequest request) {
//		String email = request.getParameter("email");
//		System.out.println(email);
//		return "";
//	}
	
//	----------using RequestParam -------------
//	public String handleForm(@RequestParam("email") String email ,
//							@RequestParam("password") String password ,
//							@RequestParam("name") String name,Model model
//			) {
//		System.out.println(email);
//		user_email = email;
//		System.out.println(password);
//		user_password = password;
//		System.out.println(name);
//		uname = name;
//
//		model.addAttribute("email", email);
//		model.addAttribute("password",password);
//		model.addAttribute("name",name);
//		return "success";
//	}
	
//	-------***----using @ModelAttribute method------***----
	// Best method bcz it is shorter and only we need to assign a class User 
	@RequestMapping(path="/processform",method=RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user,Model model) {
//		User user = new User();
//		user.setEmail(email);
//		user.setPassword(password);
//		user.setName(name);
//		model.addAttribute("user",user);
		System.out.println(user);
		//Step below is to send data to database
		this.userService.createUser(user);
		
		return "success";
	}
	
}
