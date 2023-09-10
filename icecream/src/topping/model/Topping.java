package topping.model;

public class Topping {

	private String toppingId;
	private String toppingName;
	private int additionalPrice;
	private int stockQuantity;
	
	public Topping(String toppingId, String toppingName, int additionalPrice, int stockQuantity) {
		super();
		this.toppingId = toppingId;
		this.toppingName = toppingName;
		this.additionalPrice = additionalPrice;
		this.stockQuantity = stockQuantity;
	}

	public String getToppingId() {
		return toppingId;
	}

	public void setToppingId(String toppingId) {
		this.toppingId = toppingId;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public int getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(int additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Topping [toppingId=" + toppingId + ", toppingName=" + toppingName + ", additionalPrice="
				+ additionalPrice + ", stockQuantity=" + stockQuantity + "]";
	}
	
	
}
