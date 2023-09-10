package orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import orderDetail.dao.OrderDetailDao;
import orders.dao.OrdersDao;
import orders.model.OrderInfo;

public class OrderService {

	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
//	@Autowired
//	private ProductDao productDao;
//	
//	@Autowired
//	private ToppingDao toppingDao;
//	
//	@Autowired
//	private ToppingDetailDao toppingDetailDao;
	
	public int createOrder(String json) {
		String str = String.valueOf(ordersDao.createOrder(json));
		int num = Integer.parseInt(str);
		orderDetailDao.createOrderDetail(json, num);
		return num;
	}
	
	public List<OrderInfo> selectOrderDetailById(int id) {
		return ordersDao.selectOrderDetailById(id);
	}
	
	public List<String> selectProductIdByOrderID(int orderId){
		return orderDetailDao.selectProductIdByOrderID(orderId);
	}
	
	public List<OrderInfo> selectOrderInfo(int orderId) {
		return ordersDao.selectOrderInfo(orderId);
	}
	
}
