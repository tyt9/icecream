package icecreamDetail.model;

public class IcecreamDetail {

	private int orderId;
	private int detailId;
	private int productId;
	private int toppingId;
	
	public IcecreamDetail(int orderId, int detailId, int productId, int toppingId) {
		super();
		this.orderId = orderId;
		this.detailId = detailId;
		this.productId = productId;
		this.toppingId = toppingId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	@Override
	public String toString() {
		return "IcecreamDetail [orderId=" + orderId + ", detailId=" + detailId + ", productId=" + productId
				+ ", toppingId=" + toppingId + "]";
	}
	
	
}
