package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
//	@GetMapping("/hello")
//	public String hello(Model model, 
//			@RequestParam(value="name",required = false) String name) {
//		model.addAttribute("greeting", "안녕하세요,"+name);
//		return "hello";
//	}
	
	@GetMapping("/add")
	public String add() {
		return "addForm";
	}
	
	@PostMapping("/result")
	public String res(Model model, 
			@RequestParam(required = true, defaultValue = "1") Integer fir,
			@RequestParam(required = true, defaultValue = "1") Integer sec) {
		model.addAttribute("greeting", fir+sec);
//		System.out.println(fir+sec);
		return "res";
	}
}
