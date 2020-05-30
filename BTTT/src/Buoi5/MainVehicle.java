package Buoi5;

import java.util.Scanner;

public class MainVehicle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Số lượng bánh xe moto: ");
		int numberOfWhellMoto = sc.nextInt();
		System.out.println("Nhiên liệu: ");
		String chen = sc.nextLine();
		String fuelMoto = sc.nextLine();
		System.out.println("Hãng sản xuất: ");
		String manufacturerMoto = sc.nextLine();
		Motobike moto = new Motobike(numberOfWhellMoto, fuelMoto, manufacturerMoto);
		System.out.println("--------------------------------------------------------");
		System.out.println("Số lượng bánh xe ô tô: ");
		int numberOfWhellCar = sc.nextInt();
		System.out.println("Nhiên liệu: ");
		String chen1 = sc.nextLine();
		String fuelCar = sc.nextLine();
		System.out.println("Hãng sản xuất: ");
		String manufacturerCar = sc.nextLine();
		Car car = new Car(numberOfWhellCar, fuelCar, manufacturerCar);
		
		System.out.println("Thông tin về moto");
		System.out.println("Số bánh xe: "+moto.getNumberOfWhell());
		System.out.println("Nhiên liệu: "+moto.getFuel());
		System.out.println("Hãng: " + moto.getManufacturer());
		System.out.println("Âm thanh: " + moto.sound());
		
		System.out.println("Thông tin về Car");
		System.out.println("Số bánh xe: "+car.getNumberOfWhell());
		System.out.println("Nhiên liệu: "+car.getFuel());
		System.out.println("Hãng: " + car.getManufacturer());
		System.out.println("Âm thanh: " + car.sound());
		

	}

}
