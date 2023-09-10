package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import login.dao.AdminDao;
import login.service.LoginFailException;
import login.service.LoginService;
import login.service.User;
import orderDetail.dao.OrderDetailDao;
import orders.dao.OrdersDao;
import orders.service.OrderService;
import product.dao.ProductDao;
import product.model.Product;
import topping.dao.ToppingDao;
import topping.model.Topping;
import toppingDetailDao.ToppingDetailDao;

@Controller
public class LogController {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login.do")
	public String login1() {
		
		return "loginForm";
	}
	
	@PostMapping("/login.do")
	public String login2(Model model, @RequestParam String id,
			@RequestParam String password,
			HttpServletRequest request) {
		
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return "loginForm";
		}

		try {
			User user = loginService.login(id, password);
			request.getSession().setAttribute("authUser", user);
			return "redirect:/index.jsp";
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return "loginForm";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/index.jsp";
	}
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ToppingDao toppingDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private ToppingDetailDao toppingDetailDao;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/pick")
	public String pickGet(Model model) {
		model.addAttribute("pdList",productDao.select());
		model.addAttribute("tpList",toppingDao.select());
//		System.out.println(productDao.select());
		
		return "pick3";
	}
  
//	@PostMapping("/pick")
//	public String pickPost() {
//		
//		return "pick";
//	}
	
	
	@PostMapping("/orderSuccess")
	public String orderSuccess(Model model, @RequestBody String json) {
		System.out.println(json);
//		String str = String.valueOf(ordersDao.createOrder(json));
//		int num = Integer.parseInt(str);
//		orderDetailDao.createOrderDetail(json, num);
		
//		model.addAttribute("order",ordersDao.selectOrderDetailById(num));
		int num = orderService.createOrder(json);
		model.addAttribute("order",orderService.selectOrderDetailById(num));
		
//		List<String> productIdList = orderDetailDao.selectProductIdByOrderID(num);
		List<String> productIdList = orderService.selectProductIdByOrderID(num);
		model.addAttribute("pdList",productIdList);
		model.addAttribute("orderInfo", orderService.selectOrderInfo(num));
		return "orderSuccess";
	}
	
	@GetMapping("/previousOrders")
	public String previousOrders(Model model) {
		model.addAttribute("list",ordersDao.selectOrderInfos());
		return "previousOrders";
	}
	
	@PostMapping("/api/members")
	@ResponseBody
	public String delOrderId(@RequestParam String id) {
		System.out.println(id);
		ordersDao.deleteOrder(Integer.parseInt(id));
//		Member member = memberDAO.selectById(id);
//		System.out.println(member);
		return "true";
	}
	
	@GetMapping("/pdManagement")
	public String pdM() {
		return "pdManagement";
	}
	
	@GetMapping("/addIce")
	public String addIce() {
		return "addIce";
	}
	
	
	
	@GetMapping("/addTop")
	public String addTop() {
		return "addTop";
	}
	
	@PostMapping("/addIceSuccess")
	public String addIceSuccess(Model model, @RequestParam String productId,
			@RequestParam String productName, @RequestParam int price) {
		productDao.insertIcecream(new Product(productId, productName, price, 0));
		model.addAttribute("list",productDao.select());
		return "addIceSuccess";
	}
	
	@PostMapping("/addTopSuccess")
	public String addTopSuccess(Model model, @RequestParam String toppingId,
			@RequestParam String toppingName, @RequestParam int additionalPrice) {
		toppingDao.insertTopping(new Topping(toppingId, toppingName, additionalPrice, 0));
		model.addAttribute("list",toppingDao.select());
		return "addTopSuccess";
	}
}









