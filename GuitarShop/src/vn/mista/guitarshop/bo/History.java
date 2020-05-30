package vn.mista.guitarshop.bo;

public class History {
	private int historyID;
	private int userID;
	private String fullName;
	private int productID;
	private String productName;
	private int quantity;
	private int price;
	public History() {
		super();
	}
	
	
	public History(int historyID, int userID, String fullName, int productID, String productName, int quantity,
			int price) {
		super();
		this.historyID = historyID;
		this.userID = userID;
		this.fullName = fullName;
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}


	public int getHistoryID() {
		return historyID;
	}
	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
 