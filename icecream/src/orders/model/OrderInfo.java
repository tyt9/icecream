package orders.model;

import java.util.Date;

public class OrderInfo {
	private int orderId;
    private int orderDetailId;
    private Date orderDateTime;
    private int totalAmount;
    private String productId;
    private String toppingDetailId;
    private String toppingId;
    private String productName;
    private String toppingName;
    
	
    
	public OrderInfo(int orderId, int orderDetailId, Date orderDateTime, int totalAmount, String productId,
			String toppingDetailId, String toppingId, String productName, String toppingName) {
		super();
		this.orderId = orderId;
		this.orderDetailId = orderDetailId;
		this.orderDateTime = orderDateTime;
		this.totalAmount = totalAmount;
		this.productId = productId;
		this.toppingDetailId = toppingDetailId;
		this.toppingId = toppingId;
		this.productName = productName;
		this.toppingName = toppingName;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getOrderDetailId() {
		return orderDetailId;
	}



	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
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



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getToppingDetailId() {
		return toppingDetailId;
	}



	public void setToppingDetailId(String toppingDetailId) {
		this.toppingDetailId = toppingDetailId;
	}



	public String getToppingId() {
		return toppingId;
	}



	public void setToppingId(String toppingId) {
		this.toppingId = toppingId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getToppingName() {
		return toppingName;
	}



	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}



	public OrderInfo() {
	}



	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderDetailId=" + orderDetailId + ", orderDateTime=" + orderDateTime
				+ ", totalAmount=" + totalAmount + ", productId=" + productId + ", toppingDetailId=" + toppingDetailId
				+ ", toppingId=" + toppingId + ", productName=" + productName + ", toppingName=" + toppingName + "]";
	}
    
    
}
