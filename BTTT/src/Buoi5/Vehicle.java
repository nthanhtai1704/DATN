package Buoi5;

public abstract class Vehicle {
	private int numberOfWhell;// số lượng
	private String fuel; // nhiên liệu
	private String manufacturer;// hãng sane xuất

	public abstract String sound(); // âm thanh

	public Vehicle(int numberOfWhell, String fuel, String manufacturer) {
		super();
		this.numberOfWhell = numberOfWhell;
		this.fuel = fuel;
		this.manufacturer = manufacturer;
	}

	public int getNumberOfWhell() {
		return numberOfWhell;
	}

	public void setNumberOfWhell(int numberOfWhell) {
		this.numberOfWhell = numberOfWhell;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
