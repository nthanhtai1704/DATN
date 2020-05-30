package vn.mista.hellospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class RequestParamExampleController {
  
  @RequestMapping("/user")
  public String userInfo(Model model,
          @RequestParam(value = "name", defaultValue = "Thanh Tai") String name) {
 
      model.addAttribute("name", name);
 
      if ("admin".equals(name)) {
          model.addAttribute("email", "admin@example.com");
      } else {
          model.addAttribute("email", "nthanhtai1704@gmail.com");
      }
      return "userInfo";
  }
 
}