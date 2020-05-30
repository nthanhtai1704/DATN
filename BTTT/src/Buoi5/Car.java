package Buoi5;

public class Car extends Vehicle {

	public Car(int numberOfWhell, String fuel, String manufacturer) {
		super(numberOfWhell, fuel, manufacturer);
	}

	@Override
	public String sound() {
		return "Huwmmmm :V";
	}
}
