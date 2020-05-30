package StudentManagement;

public class Student {

	private int id;
	private String fistName;
	private String lastName;
	private String gender;
	private int age;
	private String telephone;
	private int score;
	
	public Student() {
		super();
	}
	
	public Student(int id, String fistName, String lastName, String gender, int age, String telephone, int score) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.telephone = telephone;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
