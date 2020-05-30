package Buoi5;

public class Motobike extends Vehicle {

	public Motobike(int numberOfWhell, String fuel, String manufacturer) {
		super(numberOfWhell, fuel, manufacturer);
	}

	@Override
	public String sound() {
		return "brum";
	}
}
