package vo;

public class Person {
	private int seq_person;
	private String name;		// 이름
	private String ssn;			// 주민번호
	private int age;			// 나이
	private String type;
	
	public Person() {
		
	}
	
	public Person(String name, String ssn, int age, String type) {
		this.name = name;
		this.ssn = ssn;
		this.age = age;
		this.type = type;
	}

	public int getSeq_person() {
		return seq_person;
	}

	public void setSeq_person(int seq_person) {
		this.seq_person = seq_person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return " Person [seq_person = " + seq_person + ", name = " + name + ", ssn = " + ssn + ", age = " + age + ", type="
				+ type + " ]";
	}
	

}
