package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		price=quantity*product.getPrice();
		return price;
	}

	public String toString() {
		return product.getName()
				+ ", "
				+String.format("%.2f", product.getPrice())
				+", "
				+"Quantity: "
				+quantity
				+", Subtotal: $"
				+subTotal()
				+"\n";
	}
	
	
}
