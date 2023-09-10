package orderDetail.model;

public class OrderDetail {

	private int detailId;
	private int orderId;
	private String productId;
	private int quantity;
	
	public OrderDetail(int detailId, int orderId, String productId, int quantity) {
		super();
		this.detailId = detailId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [detailId=" + detailId + ", orderId=" + orderId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	
	
}
