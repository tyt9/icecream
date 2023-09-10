package orders.model;

import java.util.Date;

public class Orders {

	private int orderId;
	private Date orderDateTime;
	private int totalAmount;
	
	public Orders(int orderId, Date orderDateTime, int totalAmount) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.totalAmount = totalAmount;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDateTime=" + orderDateTime + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
