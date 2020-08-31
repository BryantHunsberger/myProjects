package Lab_11;

/*	
C212 - Lab 11 - Block
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/22/2020 
*/

// This class serves to hold the quantity and price for certain stocks from the implementation class
public class Block {

	private int quantity;
	private double price;
	
	public Block(int quantity, double price)
	{
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
