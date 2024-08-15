package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	 
//	Binding variable from url to handler
	@RequestMapping("/book/{id}")
	public String handleit(@PathVariable("id") int id) {
		System.out.println(id);
		return "home";
	}
	
	@RequestMapping("/fileform")
	public String showForm() {
		String str = "";
		
		return "fileupload";
	}
	 
	@RequestMapping(value="/uploadImage", method=RequestMethod.POST)
	public String fileupload(@RequestParam("profile") CommonsMultipartFile file)
	{
		System.out.println("inside fileupload");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		return "filesuccess";
	}
	
////	Handling specific exception in spring mvc
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //Sending Status code
//	@ExceptionHandler(value = NullPointerException.class)
//	public String exceptionHandlerNull() {
//		return "nullPage";
//	}
//	
////	General exception handling in spring mvc
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //Sending Status code
//	@ExceptionHandler(value = Exception.class)
//	public String exceptionHandlerGeneral() {
//		return "nullPage";
//	}
	
}
