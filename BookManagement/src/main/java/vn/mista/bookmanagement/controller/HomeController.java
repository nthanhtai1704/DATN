package vn.mista.bookmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.fabric.xmlrpc.base.Value;

@Controller
public class HomeController {

	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public String hello(Model model) {
		return "homepage";

	}
	
	@RequestMapping(value = { "/login"})
	public String login() {
		return "login";

	}
	@RequestMapping(value = { "/403"})
	public String accessDenied() {
		return "403";
		
	}
}
