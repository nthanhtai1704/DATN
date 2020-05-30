package model;

import java.io.Serializable;

public class Sanpham implements Serializable{
	private int id;
	
	private byte [] avatar;
	private String name;
	private String species;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public byte[] getAvatar() {
		return avatar;
	}
	public Sanpham() {
		super();
	}
	public Sanpham(int id, byte[] avatar, String name, String species, int quantity) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.name = name;
		this.species = species;
		this.quantity = quantity;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
