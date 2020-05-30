package Buoi4;

public class Tree {
	String name = "apple";
	int age= 10;
	final String type = "fruit trees";
	int numberOfFruit = 100;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfFruit() {
		return numberOfFruit;
	}

	public void setNumberOfFruit(int numberOfFruit) {
		this.numberOfFruit = numberOfFruit;
	}

	public String getType() {
		return type;
	}

	public  void haiQua(int number) {
		numberOfFruit = numberOfFruit - number;
		System.out.println("");
	}
	
	public static void main (String arsg[]) {
		Tree myObj =  new Tree();
		System.out.println(myObj.name);
		System.out.println(myObj.age);
		System.out.println(myObj.type);
		
		myObj.age = 12;
		//myObj.type = "abc";
		
		System.out.println(myObj.age);
		
		Tree myObj2 = new Tree();
		System.out.println(myObj2.age);
		myObj2.haiQua(25);
		System.out.println(myObj2.numberOfFruit);
		
	}
}
