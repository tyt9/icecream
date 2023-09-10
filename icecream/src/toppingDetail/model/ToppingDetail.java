package toppingDetail.model;

public class ToppingDetail {

	private int toppingDetailId;
	private int orderDetailId;
	private String toppingId;
	private int toppingQuantity;
	
	public ToppingDetail(int toppingDetailId, int orderDetailId, String toppingId, int toppingQuantity) {
		super();
		this.toppingDetailId = toppingDetailId;
		this.orderDetailId = orderDetailId;
		this.toppingId = toppingId;
		this.toppingQuantity = toppingQuantity;
	}

	public int getToppingDetailId() {
		return toppingDetailId;
	}

	public void setToppingDetailId(int toppingDetailId) {
		this.toppingDetailId = toppingDetailId;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getToppingId() {
		return toppingId;
	}

	public void setToppingId(String toppingId) {
		this.toppingId = toppingId;
	}

	public int getToppingQuantity() {
		return toppingQuantity;
	}

	public void setToppingQuantity(int toppingQuantity) {
		this.toppingQuantity = toppingQuantity;
	}

	@Override
	public String toString() {
		return "ToppingDetail [toppingDetailId=" + toppingDetailId + ", orderDetailId=" + orderDetailId + ", toppingId="
				+ toppingId + ", toppingQuantity=" + toppingQuantity + "]";
	}
	
	
}
