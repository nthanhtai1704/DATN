package Buoi5;

import java.util.ArrayList;

public class VdArrayList {
	public static void main(String a[]) {
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Ferrari");
		cars.add("Folo");
		cars.add("Bò");

		System.out.println("Số phần tử: " + cars.size());
		for (int i = 0; i < cars.size(); i++) {
			if (i % 2 == 0) {
				cars.set(i, "Xe " + cars.get(i));
			}
		}
		
	}
}
