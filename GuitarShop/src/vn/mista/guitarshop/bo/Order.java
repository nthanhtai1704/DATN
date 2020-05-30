package vn.mista.guitarshop.bo;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	private int orderID;
	private User customer;
	private List<Item> items;
	private int status;
	
	public Order() {
		this.status = 0;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
