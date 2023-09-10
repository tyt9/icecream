package product.model;

public class Product {

	private String productId;
	private String productName;
	private int price;
	private int stockQuantity;
	
	public Product(String productId, String productName, int price, int stockQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + "]";
	}
	
	
}
