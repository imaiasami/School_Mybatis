package vo;

public class Teacher extends Person {
	
	private int seq_teacher;
	private String major;		// 전공과목
	
	public Teacher () {
		
	}
	
	public Teacher(String name, String ssn, int age, String type, String major) {
		super(name, ssn, age, type);
		this.major = major;
	}
	
	public int getSeq_teacher() {
		return seq_teacher;
	}

	public void setSeq_teacher(int seq_teacher) {
		this.seq_teacher = seq_teacher;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + " Teacher [seq_teacher = " + seq_teacher + ", major = " + major + " ]";
	}
	
	

}
