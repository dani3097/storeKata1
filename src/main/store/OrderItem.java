package store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float calculateTotalForItem() {
		float totalItem=0;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			totalItem = calculateDiscountForAccessories();
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			totalItem = calculateDiscountForBikes();
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			float cloathingDiscount = 0;
			if (getQuantity() > 2) {
				cloathingDiscount = getProduct().getUnitPrice();
			}
			totalItem = calculateTotalAmount() - cloathingDiscount;
		}
		return totalItem;
	}

	private float calculateDiscountForBikes() {
		float totalItem;
		// 20% discount for Bikes
		totalItem = calculateTotalAmount() - calculateTotalAmount() * 20 / 100;
		return totalItem;
	}

	private float calculateDiscountForAccessories() {
		float totalItem;
		float booksDiscount = 0;
		if (calculateTotalAmount() >= 100) {
			booksDiscount = calculateTotalAmount() * 10 / 100;
		}
		totalItem = calculateTotalAmount() - booksDiscount;
		return totalItem;
	}

	private float calculateTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
