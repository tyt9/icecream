package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.dao.AdminDao;
import login.service.LoginService;
//import mybatis.dao.MemberDAO;
import product.dao.ProductDao;
import topping.dao.ToppingDao;

@Controller
public class MyController {

//	@Autowired
//	private MemberDAO memberDAO;
	
	@GetMapping("/hello")
	public String wel() {
		return "hello";
	}
	
	@GetMapping("/form")
	public String hello() {
		return "form";
	}
	
	@PostMapping("/res")
	public String res(Model model,
			@RequestParam(required = true, defaultValue = "1") Integer num) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++) {
			list.add(num*i);
		}
		model.addAttribute("list",list);
		model.addAttribute("num",num);
		return "res";
	}
	
	@Autowired
	public AdminDao	adminDao;
	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	public ToppingDao toppingDao;
	
	@GetMapping("/count")
	public String cnt(Model model) {
//		System.out.println("user >"+loginService.login("test", "test"));
//		System.out.println("admin > "+adminDao.selectById("test"));
//		System.out.println(productDao.selectPriceById("ice_yogurt"));
//		System.out.println(productDao.selectById("ice_choco"));
//		System.out.println(productDao.selectQuantityById("ice_yogurt"));
//		productDao.updateProductStock("ice_yogurt", -3);
//		System.out.println(productDao.selectQuantityById("ice_yogurt"));
//		System.out.println(toppingDao.selectById("top_cherry"));
		System.out.println(toppingDao.selectAdditionalPriceById("top_cereal"));
		return "count";
	}
	
	@GetMapping("/pickId")
	public String pickId(Model model) {
		return "pickId";
	}
	
//	@GetMapping("/selId")
//	public String selId(Model model,
//			@RequestParam(required = true) String id) {
//		System.out.println(id);
//		model.addAttribute("selId",memberDao.selectById(id));
//		System.out.println(memberDao.selectById(id));
//		return "selId";
//	}
//	
//	@Autowired
//	private LoginService loginService;
//	
//	@Autowired
//	private ArticleContentDao articleContentDao;
	
	@Autowired
	private ProductDao productDao;
	
}





