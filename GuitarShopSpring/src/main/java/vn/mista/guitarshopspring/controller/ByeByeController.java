package vn.mista.guitarshopspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ByeByeController {

	 @RequestMapping("/bye")
	    public String bye(Model model) {
	        
	        model.addAttribute("bye", "Bye bye Spring MVC auto update");
	        
	        return "byepage";
	        
	    }
}
