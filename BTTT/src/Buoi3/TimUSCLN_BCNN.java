package Buoi3;

import java.util.Scanner;

public class TimUSCLN_BCNN {

	public static void main(String[] args) {
        int firstNumber, secondNumber, temp1, temp2, uscln, bscnn;
        Scanner scanner = new Scanner(System.in);
         
        System.out.println("Nhập vào số thứ nhất: ");
        firstNumber = scanner.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        secondNumber = scanner.nextInt();
         
        while ((firstNumber <= 0) || (secondNumber <= 0)) {
            System.out.println("Nhập lại hai số nguyên dương!");
            System.out.println("Nhập vào số thứ nhất: ");
            firstNumber = scanner.nextInt();
            System.out.println("Nhập vào số thứ hai: ");
            secondNumber = scanner.nextInt();
        }
         
        // tìm ước số chung lớn nhất
        temp1 = firstNumber;
        temp2 = secondNumber;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        uscln = temp1;
         
        System.out.println("Ước số chung lớn nhất của " + firstNumber + " và " + secondNumber + " = " + uscln);
        System.out.println("Bội số chung lớn nhất của " + firstNumber + " và " + secondNumber + " = " + 
                ((firstNumber * secondNumber) / uscln));
    }
}
