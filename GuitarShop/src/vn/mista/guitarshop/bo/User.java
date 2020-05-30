package vn.mista.guitarshop.bo;

import java.io.Serializable;

public class User implements Serializable{

	private int userID;
	private String userName;
	private String password;
	private String fullName;
	private String tel;
	private int idCard;
	private String email;
	private String address;
	private String role;
	
	public User() {
		super();
	}

	public User(int userID, String userName, String password, String fullName, String tel, int idCard, String email,
			String address, String role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.tel = tel;
		this.idCard = idCard;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

		
}
