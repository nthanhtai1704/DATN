package vn.mista.guitarshop.bo;

import java.io.Serializable;

public class Product implements Serializable {
	private int productID;
	private byte[] productImg;
	private String productName;
	private String productType;
	private int amount;
	private int price;
	
	public Product() {
		super();
	}

	public Product(int productID, byte[] productImg, String productName, String productType, int amount, int price) {
		super();
		this.productID = productID;
		this.productImg = productImg;
		this.productName = productName;
		this.productType = productType;
		this.amount = amount;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public byte[] getProductImg() {
		return productImg;
	}

	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

				
}
