package vn.mista.connectdb.bo;

public class User {
	private int id;
	private String name;
	private String pass;
	private int age;
	
	public User() {
		super();
	}

	public User(int id, String name, String pass, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
